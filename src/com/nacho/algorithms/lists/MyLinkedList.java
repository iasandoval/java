package com.nacho.algorithms.lists;

/**
 * Parent abstract class to be implemented by LinkedList classes.
 * 
 * @author iasandoval
 *
 * @param <E> Element type.
 */
public abstract class MyLinkedList<E> {

    // Size of the list
    private int size;

    /**
     * Default constructor.
     */
    public MyLinkedList() {
	// Prints the name of the class
	System.out.println(this.getClass().getSimpleName());
	System.out.println("");
    }

    /**
     * Get the Size of the list.
     * 
     * @return The size of the list.
     */
    protected int getSize() {
	return this.size;
    }

    /**
     * Determine if the list is empty.
     * 
     * @return True if the list is empty.
     */
    protected boolean isEmpty() {
	return this.size == 0;
    }

    /**
     * Method to increment the size + 1.
     */
    protected void incrementSize() {
	this.size++;
    }

    /**
     * Method to decrement the size + 1.
     */
    protected void decrementSize() {
	this.size--;
    }

    protected void view() {
	System.out.println("List Size          : " + this.getSize());
	System.out.println("Head/First element : " + this.getFirst());
	System.out.println("Tail/Last element  : " + this.getLast());
	System.out.println("List               : " + this.toString());
	System.out.println("");
    }

    /**
     * Add the element in the head of the list.
     * 
     * @param element Element to be added in the head of the list.
     */
    public abstract void addFirst(E element);

    /**
     * Add the element in the tail of the list.
     * 
     * @param element Element to add in the tail of the list.
     */
    public abstract void addLast(E element);

    /**
     * Remove and return the first element of the list.
     * 
     * @return The first element of the list.
     */
    public abstract E removeFirst();

    /**
     * Get the first element of the list.
     * 
     * @return First element of the list.
     */
    public abstract E getFirst();

    /**
     * Return the last element of the list.
     * 
     * @return The last element of the list.
     */
    public abstract E getLast();

    /**
     * Returns the list to String
     * 
     * @return The list as String
     */
    public abstract String toString();

}
