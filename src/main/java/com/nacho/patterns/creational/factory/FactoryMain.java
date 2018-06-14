package com.nacho.patterns.creational.factory;

public class FactoryMain {

    public static void main(String[] args) {

        Factory car = TransportFactory.getTransport("car");
        System.out.println(car.getProduct());

        Factory train = TransportFactory.getTransport("train");
        System.out.println(train.getProduct());

        Factory bicycle = TransportFactory.getTransport("bicycle");
        System.out.println(bicycle.getProduct());


    }
}
