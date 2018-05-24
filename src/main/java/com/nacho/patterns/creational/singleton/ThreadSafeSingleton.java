package com.nacho.patterns.creational.singleton;

/**
 * Class that represents the Lazy Singleton.
 *
 * @author IASandoval
 */
public class ThreadSafeSingleton implements Singleton {

    /**
     * Instance of the Singleton.
     */
    private static ThreadSafeSingleton instance;

    /**
     * General attributes of the class.
     */
    private String name;

    /**
     * Private constructor.
     */
    private ThreadSafeSingleton() {
        this.setName("I'm Thread-Safe Singleton");
    }

    /**
     * Get the instance of the class with double checked locking.
     *
     * @return The instance of the class.
     */
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * Getter of the name
     *
     * @return The Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of the Name
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
