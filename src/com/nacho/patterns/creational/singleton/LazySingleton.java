package com.nacho.patterns.creational.singleton;

/**
 * Class that represents the Lazy Singleton.
 *
 * @author IASandoval
 */
public class LazySingleton implements Singleton {

    /**
     * Instance of the Singleton.
     */
    private static LazySingleton instance;

    /**
     * General attributes of the class.
     */
    private String name;

    /**
     * Private constructor.
     */
    private LazySingleton() {
        this.setName("I'm Lazy Singleton");
    }

    /**
     * Get the instance of the class.
     *
     * @return The instance of the class.
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
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
