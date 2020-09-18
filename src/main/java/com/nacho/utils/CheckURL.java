package com.nacho.utils;

import org.junit.Test;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckURL {


    @Test
    public void test() {
        CheckURL url = new CheckURL();
        //url.checkURL("https://167.195.160.139:9444/");
        //url.checkURL("https://xapt11diestl08e:9444/");
        //url.checkURL("http://www.galeriamazatlan.com");
        //url.checkURL("http://www.google.com");
        //url.checkURL("https://www.google.com");
        //url.checkURL("https://www.ignaciosandoval.com");

        url.checkSSLURL("167.195.160.139",9444);
    }

    public void checkSSLURL(String domain, int port) {
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(domain, port);

            InputStream in = sslsocket.getInputStream();
            OutputStream out = sslsocket.getOutputStream();

            // Write a test byte to get a reaction :)
            out.write(1);

            while (in.available() > 0) {
                System.out.print(in.read());
            }

            System.out.println("Successfully connected");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void checkURL(String domain) {

        try {

            //SSLContext sslctx = SSLContext.getInstance("SSL");
            //sslctx.init(null, new X509TrustManager[] { new MyTrustManager()}, null);
            //HttpsURLConnection.setDefaultSSLSocketFactory(sslctx.getSocketFactory());

            URL url = new URL(domain);

            System.out.println("Authority:      " + url.getAuthority());
            System.out.println("DefaultPort:    " + url.getDefaultPort());
            System.out.println("Path:           " + url.getPath());
            System.out.println("Port:           " + url.getPort());
            System.out.println("Protocol:       " + url.getProtocol());
            System.out.println("Query:          " + url.getQuery());
            System.out.println("Ref:            " + url.getRef());
            System.out.println("UserInfo:       " + url.getUserInfo());
            //System.out.println("Content:        " + read(url.openStream()));

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (domain.startsWith("https://")) {
                con = (HttpsURLConnection) url.openConnection();
            }

            con.setRequestMethod("HEAD");
            con.setConnectTimeout(3000);

            con.connect();

            System.out.println("Status Code     : " + con.getResponseCode() + " " + con.getResponseMessage());

            con.getHeaderFields().entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            });

            if (con.getResponseCode() == 301) {
                List<String> loc = con.getHeaderFields().get("Location");
                String location = loc.get(0);
                System.out.println("Location     : " + location);
                checkURL(location);
            }

        } catch (MalformedURLException e) {
            //Exception due URL url = new URL(domain);
            e.printStackTrace();
        } catch (IOException /*| NoSuchAlgorithmException | KeyManagementException*/ e) {
            // Exception due url.getContent();
            e.printStackTrace();
        }
    }


    private static String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

    class MyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String
                authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String
                authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

}
