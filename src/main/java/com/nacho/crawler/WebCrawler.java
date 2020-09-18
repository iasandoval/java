package com.nacho.crawler;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class WebCrawler {

    private HashSet<String> links;
    private Set<Dictionary> dictionarySet;
    private List<String> summary;
    //private HashMap<String, String> dictionary;

    private static final String URL_HELP = "http://localhost:9106/chimestraining/Wizards/WebHelp/%s.htm";


    @Test
    public void test() {
        //1. Pick a URL from the frontier
        //new WebCrawler().getPageLinks("http://localhost:9106/chimestraining/Wizards/WebHelp/AMMAD.htm");
        WebCrawler wc = new WebCrawler();
        //wc.readDynatables();
        wc.readPages();
        wc.writeResults();
    }

    public WebCrawler() {
        this.links = new HashSet<>();
        this.dictionarySet = new HashSet<>();
        this.summary = new ArrayList<>();
    }

    public void readPages() {
        try {
            Scanner scanner = new Scanner(new File("ADASummaryPages.txt"));

            while (scanner.hasNextLine()) {
                String pageId = scanner.nextLine();
                this.getSummary(pageId);
            }
        } catch(FileNotFoundException e) {
            System.err.println("For '" + "ADATableCaptionJS.txt" + "': " + e.getMessage());
        }
    }

    public String getSummary(String pageId) {

        String text = "";
        String URL = String.format(URL_HELP, pageId);

        try {
            System.out.println(URL);

            Document document = Jsoup.connect(URL).get();
            text = pageId + "-";
            /*Elements pageDescription = document.select("html body p");

            for (Element page : pageDescription) {
                text = pageId + "-";
                if(null != page && null != page.html() && page.text().contains("The table displays")) {
                    String tableText = Jsoup.parse(page.html()).text();
                    text += tableText.substring(tableText.indexOf("The table displays"));
                    break;
                }
            }*/

            this.summary.add(text);
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
            text = pageId + "-";
            text += e.getMessage();
            this.summary.add(text);
        }

        return text;
    }


    public void readDynatables() {
        try {
            Scanner scanner = new Scanner(new File("ADATableCaptionJS.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Dictionary dictionary = new Dictionary(line);

                dictionary.definition = this.getdefinitions(String.format(URL_HELP, dictionary.pageId), dictionary.dynatableCaption);
                System.out.println(dictionary.toString());
                this.dictionarySet.add(dictionary);
            }
        } catch(FileNotFoundException e) {
            System.err.println("For '" + "ADATableCaptionJS.txt" + "': " + e.getMessage());
        }
    }

    public void writeResults() {
        //this.writeResults("results.txt", this.dictionarySet);
        this.writeResults("resultsSummary.txt", this.summary);
    }

    private void writeResults(String fileName, Collection<Dictionary> col) {
        try (
                FileOutputStream fos = new FileOutputStream(new File(fileName));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))
        ) {

            for (Dictionary dictionary : col) {
                writer.write(dictionary.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("For 'writeResults': " + e.getMessage());
        }
    }

    private void writeResults(String fileName, List<String> col) {
        try (
                FileOutputStream fos = new FileOutputStream(new File(fileName));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))
        ) {

            for (String summary : col) {
                writer.write(summary);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("For 'writeResults': " + e.getMessage());
        }
    }



    public String getdefinitions(String URL, String caption) {

        String text = "";

        try {

            System.out.println(URL);

            Document document = Jsoup.connect(URL).get();
            Elements tables = document.select("html body table.MsoNormalTable tbody tr td p.HomeIcon b");

            for (Element page : tables) {

                if(null != page && null != page.html() && page.html().contains(caption)) {
                    Element table = tables.parents().first().parent().parent().parent().parent();
                    Element definition = table.select("table.MsoNormalTable tbody tr td p.MsoNormal").first();
                    text = definition.html();
                }
            }
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }

        return text;
    }


    class Dictionary {

        private static final String JS_LOC = "\\WPworkspace_DEV3\\IEWebApp\\WebContent\\js\\dynalist-js\\";

        String pageId;
        String dynatableJS;
        String dynatableCaption = "";
        String definition;

        File dynatableJSFile;

        public Dictionary(String dynatableJS) {
            this.dynatableJS = dynatableJS;
            this.setPageId(dynatableJS);
            this.setDynatableJSFile(dynatableJS);
            this.findCaption(this.dynatableJSFile);
        }

        private void setPageId(String dynatableJS){
            this.pageId = dynatableJS.substring(0,5).toUpperCase();
        }

        private void setDynatableJSFile(String dynatableJS){
            this.dynatableJSFile = new File(JS_LOC+dynatableJS);
        }

        private void findCaption(File jsFile) {
            try {
                Scanner scanner = new Scanner(jsFile);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if(line.trim().startsWith("caption")) {
                        this.dynatableCaption = line.trim().split(":")[1];
                        break;
                    }
                }
            } catch(FileNotFoundException e) {
                System.err.println("For '" + jsFile.getName() + "': " + e.getMessage());
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dictionary that = (Dictionary) o;
            return Objects.equals(dynatableJS, that.dynatableJS) &&
                    Objects.equals(pageId, that.pageId) &&
                    Objects.equals(dynatableCaption, that.dynatableCaption) &&
                    Objects.equals(definition, that.definition);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dynatableJS, pageId, dynatableCaption, definition);
        }

        @Override
        public String toString() {
            return "Dictionary{" +
                    "pageId='" + pageId + '\'' +
                    ", dynatableJS='" + dynatableJS + '\'' +
                    ", dynatableCaption='" + dynatableCaption + '\'' +
                    ", definition='" + definition + '\'' +
                    '}';
        }
    }

}
