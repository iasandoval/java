package com.nacho.hackerrank.bank;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class StackLarge {

    @Test
    public void test() {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(5);
        stack.push(5);
        stack.push(7);
        stack.push(8);
        stack.push(3);
        stack.pop();
    }


    class MyStack extends Stack<Integer> {

        private LinkedList<Integer> list;
        private Integer max;

        public MyStack() {
            super();
            this.list = new LinkedList<>();
            this.max = 0;
        }

        @Override
        public Integer push(Integer item) {

            if(item > this.max) {
                this.max = item;
                this.list.add(item);
            }

            System.out.println("Max = " + this.max);

            return super.push(item);
        }

        @Override
        public synchronized Integer pop() {

            Integer pop = super.pop();

            if (pop == this.max) {
                this.list.removeLast();
                this.max = this.list.getLast();
            }

            System.out.println("Max = " + this.max);

            return pop;
        }

    }

}

