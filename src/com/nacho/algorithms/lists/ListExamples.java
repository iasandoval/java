package com.nacho.algorithms.lists;

/**
 * Main class to test Linked List
 * 
 * @author iasandoval
 *
 */
public class ListExamples {

    public static void main(String[] args) {

	testSingleLinkedList();
	
	testCircularSingleLinkedList();
	
    }

    /**
     * Private method to test CircularSingleLinkedList
     */
    private static void testCircularSingleLinkedList() {
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
     * Private method to test SingleLinkedList
     */
    private static void testSingleLinkedList() {
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
