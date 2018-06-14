package com.nacho.patterns.creational.factory;

/**
 * Class that represents a Train.
 *
 * @author IASandoval
 */
public class Train implements Factory {
    public String getProduct() {
        return "I'm a Train Motherfucker!";
    }
}
