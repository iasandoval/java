package com.nacho.algorithms.lists;

/**
 * Node class
 *
 * @param <E> Element stored in this node.
 * @author iasandoval
 */
public class Node<E> {

    // Element stored in this node
    private E element;
    // Next node in the list
    private Node<E> next;

    /**
     * Node constructor.
     *
     * @param element Element to store in this Node.
     * @param node    Next node in the list
     */
    public Node(E element, Node<E> node) {
        this.element = element;
        this.next = node;
    }

    /**
     * Return the Element stored in this node.
     *
     * @return Element stored in this node.
     */
    public E getElement() {
        return this.element;
    }

    /**
     * Get the Next node.
     *
     * @return Next node.
     */
    public Node<E> getNext() {
        return this.next;
    }

    /**
     * Set the Next node.
     *
     * @param node Next node.
     */
    public void setNext(Node<E> node) {
        this.next = node;
    }
}