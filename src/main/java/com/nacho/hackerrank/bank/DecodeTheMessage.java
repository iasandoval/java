package com.nacho.hackerrank.bank;

import org.junit.Assert;
import org.junit.Test;

public class DecodeTheMessage {

    @Test
    public void test() {
        String input = "×òëúñðËèGÎÏÌáÈÝÊ";
        String output = "encoded password";

        String encoded = DecodeTheMessage.encode(output);
        String decoded = DecodeTheMessage.decode(input);

        Assert.assertEquals(encoded, input);
        Assert.assertEquals(decoded, output);

    }

    public static String encode(String text) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            b.append(c += c + i);
        }
        return b.reverse().toString();
    }

    public static String decode(String encodedMessage) {
        StringBuilder b = new StringBuilder(encodedMessage);
        String text = b.reverse().toString();
        b = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            int n = (c - i) / 2;

            b.append((char) n);
        }
        return b.toString();
    }

}
