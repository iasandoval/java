package com.nacho.algorithms.lists;

/**
 * Representation of the circular single Linked List.
 *
 * @author iasandoval
 * 
 * @param <E> Element type.
 */
public class CircularSingleLinkedList<E> extends MyLinkedList<E> {

    // Tail/Last Node
    private Node<E> tail;

    /**
     * Default constructor.
     */
    public CircularSingleLinkedList() {
	super();
    }

    /**
     * Rotate the first element to the back of the list
     */
    public void rotate() {
	// If there is a value in the tail
	if (this.tail != null) {
	    // Old head becomes the new tail
	    this.tail = this.tail.getNext();
	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFirst(E element) {
	// If the list is empty
	if (this.isEmpty()) {
	    // Add the element to the front of the list
	    this.tail = new Node<>(element, null);
	    // Link to itself
	    this.tail.setNext(this.tail);
	} else {
	    // Add it to the next position
	    Node<E> newElement = new Node<>(element, this.tail.getNext());
	    this.tail.setNext(newElement);
	}

	this.incrementSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLast(E element) {
	// Insert new element in the front of the list
	this.addFirst(element);
	// Now, the new element becomes the tail
	this.tail = this.tail.getNext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {
	E element = null;

	// If the list is not empty
	if (!this.isEmpty()) {

	    //
	    Node<E> head = this.tail.getNext();

	    // If the head equals the tail
	    if (head == this.tail) {
		// Must be the only node left
		this.tail = null;
	    } else {
		// Removes the head from the list
		this.tail.setNext(head.getNext());
	    }
	    // Decrement the size
	    this.decrementSize();
	    element = head.getElement();
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
	    element = this.tail.getNext().getElement();
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
	    Node<E> currentNode = this.tail;

	    value.append(currentNode.getElement());

	    int i = 0;
	    while (null != currentNode.getNext() && i < this.getSize()) {
		value.append("->");
		currentNode = currentNode.getNext();

		value.append(currentNode.getElement());
		i++;
	    }

	}

	return value.toString();
    }

}
