package com.nacho.patterns.creational.factory;

/**
 * Class that represents a Car.
 *
 * @author IASandoval
 */
public class Car implements Factory {

    public String getProduct() {
        return "I'm a Car.";
    }
}
