package com.nacho.algorithms.lists;

import org.junit.Test;

/**
 * Main class to test Linked List
 *
 * @author iasandoval
 */
public class ListExamples {

    @Test
    public void testAll() {

        testSingleLinkedList();

        testCircularSingleLinkedList();

        testDoubleLinkedList();

    }

    /**
     * Method to test DoubleLinkedList
     */
    @Test
    public void testDoubleLinkedList() {
        DoubleLinkedList<String> circular = new DoubleLinkedList<>();
        circular.view();

        circular.addFirst("A");
        circular.view();

        circular.addFirst("B");
        circular.view();

        circular.addFirst("C");
        circular.view();

        circular.addLast("D");
        circular.view();
    }

    /**
     * Method to test CircularSingleLinkedList
     */
    @Test
    public void testCircularSingleLinkedList() {
        CircularSingleLinkedList<String> circular = new CircularSingleLinkedList<>();
        circular.view();

        circular.addFirst("A");
        circular.view();

        circular.addFirst("B");
        circular.view();

        circular.addFirst("C");
        circular.view();

        circular.addLast("D");
        circular.view();

        circular.rotate();
        circular.view();

        circular.rotate();
        circular.view();
    }

    /**
     * Method to test SingleLinkedList
     */
    @Test
    public void testSingleLinkedList() {
        SingleLinkedList<String> simple = new SingleLinkedList<>();
        simple.view();

        simple.addFirst("A");
        simple.view();

        simple.addFirst("B");
        simple.view();

        simple.addFirst("C");
        simple.view();

        simple.addLast("D");
        simple.view();
    }

}
