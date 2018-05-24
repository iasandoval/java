package com.nacho.patterns.creational.singleton;

public class SingletonMain {

    public static void main(String[] args) {

        // Lazy Singleton
        Singleton lazy = LazySingleton.getInstance();
        System.out.println(lazy.getName());
        lazy.setName("My name has been changed");

        // Thread Safe Singleton
        Singleton threadSafe = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafe.getName());
        threadSafe.setName("New Thread Safe name");

        // Current instance will keep the previous values
        Singleton lazy2 = LazySingleton.getInstance();
        System.out.println(lazy2.getName());

        Singleton threadSafe2 = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafe2.getName());

    }

}
