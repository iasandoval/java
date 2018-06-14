package com.nacho.patterns.creational.factory;

/**
 * Class that represents the Factory Implementation.
 *
 * @author IASandoval
 */
public class TransportFactory {

    /**
     * Method to return an object bases in the provided type.
     *
     * @param type The type of the Transport.
     * @return An object with the requested Transport.
     */
    public static Factory getTransport(String type) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("bicycle".equalsIgnoreCase(type)) {
            return new Bicycle();
        } else if ("train".equalsIgnoreCase(type)) {
            return new Train();
        } else {
            return null;
        }
    }

}
