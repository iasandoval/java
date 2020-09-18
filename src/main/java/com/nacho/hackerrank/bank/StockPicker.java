package com.nacho.hackerrank.bank;

import org.junit.Assert;
import org.junit.Test;

public class StockPicker {

    private Stock buy;
    private Stock sell;
    private int profit;

    private static final String RESPONSE = "BUY@%s on day %s and SELL@%s on day %s. For a profit of $%s per share!";

    class Stock {
        final int day;
        final int price;

        public Stock(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    public void pick(int[] a) {
        this.buy = new Stock(1, a[0]);
        this.sell = new Stock(1, a[0]);

        for (int i = 0; i < a.length; i++) {
            if (a[i] > this.buy.price) {
                this.sell = new Stock(i + 1, a[i]);
            } else {
                if (i + 1 < a.length ) {
                    this.buy = new Stock(i + 1, a[i]);
                }
            }
        }
    }

    public String printPick(){
        this.profit = sell.price - buy.price;

        String res = String.format(RESPONSE, buy.price, buy.day, sell.price, sell.day, profit);
        System.out.println(res);

        return res;
    }


    @Test
    public void test() {

        int[] a = {100, 99, 100, 101, 80};

        StockPicker sp = new StockPicker();

        sp.pick(a);

        Assert.assertEquals(sp.printPick(), "BUY@99 on day 2 and SELL@101 on day 4. For a profit of $2 per share!");
    }

    @Test
    public void test2() {

        int[] a = {99, 100, 80, 105};

        StockPicker sp = new StockPicker();

        sp.pick(a);

        Assert.assertEquals(sp.printPick(), "BUY@80 on day 3 and SELL@105 on day 4. For a profit of $25 per share!");
    }

    @Test
    public void test3() {

        int[] a = {105, 100, 99, 80};

        StockPicker sp = new StockPicker();

        sp.pick(a);

        sp.printPick();

        //Assert.assertEquals(sp.printPick(), "BUY@80 on day 3 and SELL@105 on day 4. For a profit of $25 per share!");
    }


}
