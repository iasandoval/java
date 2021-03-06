package com.nacho.algorithms.lists;

/**
 * Representation of the single Linked List.
 *
 * @param <E> Element type.
 * @author iasandoval
 */
public class SingleLinkedList<E> extends MyLinkedList<E> {

    // Head/First Node
    private Node<E> head;
    // Tail/Last Node
    private Node<E> tail;

    /**
     * Default constructor.
     */
    public SingleLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFirst(E element) {
        // Create new node
        this.head = new Node<>(element, this.head);

        // If the list is empty
        if (this.isEmpty()) {
            // The last element is the first one
            this.tail = this.head;
        }

        this.incrementSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);

        // If the list is empty
        if (this.isEmpty()) {
            // Add it to the head
            this.head = newNode;
        } else {
            // Add it to the tail
            this.tail.setNext(newNode);
        }

        this.tail = newNode;

        this.incrementSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {
        E element = null;

        // If the list is not empty
        if (!this.isEmpty()) {
            // Get first element
            element = this.head.getElement();
            // Now, the first element is the next one
            this.head = this.head.getNext();
            // Decrement the size
            this.decrementSize();

            // If the list is empty
            if (this.isEmpty()) {
                // Remove the tail
                this.tail = null;
            }
        }

        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getFirst() {
        E element = null;

        // If the list is not empty
        if (!this.isEmpty()) {
            // Get the first element in the list
            element = this.head.getElement();
        }

        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getLast() {
        E element = null;

        // If the list is not empty
        if (!this.isEmpty()) {
            // Get the last element in the list
            element = this.tail.getElement();
        }

        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();

        if (!this.isEmpty()) {
            Node<E> currentNode = this.head;

            value.append(currentNode.getElement());

            while (null != currentNode.getNext()) {
                value.append("->");
                currentNode = currentNode.getNext();

                value.append(currentNode.getElement());
            }

        }

        return value.toString();
    }

}
