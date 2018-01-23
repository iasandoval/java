package com.nacho.algorithms.lists;

public class DoubleLinkedList<E> extends MyLinkedList<E> {

    // Header of the list
    private Node<E> header;
    // Caboose of the list
    private Node<E> caboose;

    /**
     * Default constructor.
     */
    public DoubleLinkedList() {
	this.header = new Node<>(null, null, null);
	this.caboose = new Node<>(null, this.header, null);
	this.header.setNext(this.caboose);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFirst(E element) {
	this.addBetween(element, this.header, this.header.getNext());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLast(E element) {
	this.addBetween(element, this.caboose.getPrevious(), this.caboose);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {
	E element = null;

	// If the list is not empty
	if (!this.isEmpty()) {
	    element = this.remove(this.header.getNext());
	}

	return element;
    }

    /**
     * Removes the last element in the list.
     * 
     * @return The last element in the list.
     */
    public E removeLast() {
	E element = null;

	// If the list is not empty
	if (!this.isEmpty()) {
	    element = this.remove(this.caboose.getPrevious());
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
	    element = this.header.getNext().getElement();
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
	    element = this.caboose.getPrevious().getElement();
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
	    Node<E> currentNode = this.header;

	    value.append("Header");

	    int i = 0;
	    while (null != currentNode.getNext() && i < this.getSize()) {
		value.append("<->");
		currentNode = currentNode.getNext();

		value.append(currentNode.getElement());
		i++;
	    }
	    
	    value.append("<->");
	    value.append("Caboose");
	    
	}

	return value.toString();
    }

    /**
     * Adds element to the linked list in between of the given nodes.
     * 
     * @param element Element to add
     * @param predecessor Predecessor Node
     * @param successor Successor Node
     */
    private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
	Node<E> newNode = new Node<>(element, predecessor, successor);
	predecessor.setNext(newNode);
	successor.setPrevious(newNode);
	this.incrementSize();
    }

    /**
     * Removes the node from the list.
     * 
     * @param node The node to remove.
     * @return
     */
    private E remove(Node<E> node) {
	Node<E> predecessor = node.getPrevious();
	Node<E> sucessor = node.getNext();

	predecessor.setNext(sucessor);
	sucessor.setPrevious(predecessor);
	this.decrementSize();

	return node.getElement();
    }

    /**
     * Inner-class to override the simple Node, and make it double linked node
     * 
     * @author iasandoval
     *
     * @param <E> Element stored in this node.
     */
    private static class Node<E> {

	// Element stored in this node
	private E element;
	// Next node in the list
	private Node<E> next;
	// Previous node in the list
	private Node<E> previous;

	/**
	 * Default constructor.
	 * 
	 * @param element Element to store in the Node
	 * @param prev Previous Node
	 * @param next Next Node
	 */
	public Node(E element, Node<E> prev, Node<E> next) {
	    this.element = element;
	    this.next = next;
	    this.previous = prev;
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

	/**
	 * Get the previous node
	 * 
	 * @return the previous node
	 */
	public Node<E> getPrevious() {
	    return previous;
	}

	/**
	 * Set the previous node
	 * 
	 * @param previous the previous node
	 */
	public void setPrevious(Node<E> previous) {
	    this.previous = previous;
	}

    }
}
