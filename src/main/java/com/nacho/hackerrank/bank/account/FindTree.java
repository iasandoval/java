package com.nacho.hackerrank.bank.account;

import org.junit.Test;

public class FindTree {

    private Node root;

    @Test
    public void test() {

    }

    private Node add(Node current, int value) {

        if(current == null){
            return new Node(value);
        }

        if(value < current.value) {
            current.left = add(current.left, value);
        } else if(value > current.value) {
            current.right = add(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        this.root = add(this.root, value);
    }


    class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
}
