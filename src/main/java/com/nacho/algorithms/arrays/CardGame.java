package com.nacho.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class CardGame {

    private static final String[] CARD_TYPES = {"D", "P", "C", "T"};
    private static final String[] CARD_NUMBERS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private String[] cards = new String[CARD_TYPES.length*CARD_NUMBERS.length];


    public CardGame() {
        int i = 0;
        for(String t:CARD_TYPES){
            for(String n : CARD_NUMBERS) {
                cards[i] = t+n;
                i++;
            }
        }
    }


    public String[] shuffleCards() {

        String[] c = this.cards.clone();
        int size = c.length;

        Random random = new Random();

        for(int i=0;i<size;i++) {
            // Generate random Index
            int rnd = random.nextInt(size);
            // Save the object in position i
            String temp = c[i];
            // Replace the object in position i from the random position
            c[i] = c[rnd];
            // Switch the object with the random position
            c[rnd] = temp;
        }

        return c;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(cards));
        String[] shufledCards = this.shuffleCards();
        System.out.println(Arrays.toString(shufledCards));
    }

}
