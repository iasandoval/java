package com.nacho.patterns.creational.factory;

/**
 * Class that represents a Bicycle.
 *
 * @author IASandoval
 */
public class Bicycle implements Factory {

    public String getProduct() {
        return "Go go pedal!";
    }
}
