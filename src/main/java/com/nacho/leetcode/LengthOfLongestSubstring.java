package com.nacho.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    @Test
    public void test1() {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();

        Assert.assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void test2() {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();

        Assert.assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void test3() {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();

        Assert.assertEquals(3, s.lengthOfLongestSubstring("pwwkewe"));
    }

    @Test
    public void test4() {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();


        Assert.assertEquals(0, s.lengthOfLongestSubstring(""));
    }

    /**
     * In general, any problem where the author is asking for any of the following return values
     * can use a sliding window:
     * Minimum value
     * Maximum value
     * Longest value
     * Shortest value
     * K-sized value
     *
     * https://levelup.gitconnected.com/an-introduction-to-sliding-window-algorithms-5533c4fe1cc7
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int windowSize = 0;
        String subString = "";

        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [leftWindow, rightWindow]
        for (int leftWindow = 0, rightWindow = 0; rightWindow < s.length(); rightWindow++) {

            // If character exists...
            if(map.containsKey(s.charAt(rightWindow))) {
                // Get the Previous Window Size
                Integer previousWindowSize = map.get(s.charAt(rightWindow));
                // Set the new left window position (Move the window to the right)
                leftWindow = Math.max(previousWindowSize, leftWindow);
            }

            // Get the Window Size
            int newWindowSize = rightWindow - leftWindow + 1;
            windowSize = Math.max(windowSize, newWindowSize);

            // Expand the Right Window
            int expandWindow = rightWindow + 1;
            map.put(s.charAt(rightWindow), expandWindow);

            subString = s.substring(leftWindow, expandWindow);

            System.out.println(subString);

        }

        return windowSize;
    }



}
