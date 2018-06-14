# Patterns

* [Creational Design Patterns](#creational-design-patterns)
    * [Factory Method](#factory-method-virtual-constructor)
    * Abstract Factory
    * Builder
    * Prototype
    * [Singleton](#singleton)
* [Structural Design Patterns](#structural-design-patterns)
    * Adapter Class
    * Adapter (Object)
    * Bridge
    * Composite
    * Decorator
    * Facade
    * Flyweight
    * Proxy
* [Behavioral Patterns](#behavioral-patterns)
    * Chain of Responsibility
    * Command
    * Interpreter
    * Iterator
    * Mediator
    * Memento
    * Observer
    * State
    * Strategy
    * The template method
    * Visitor

## Creational Design Patterns

The creational patterns intend to advocate a better way 
of creating objects, and its primary focuses are as 
follows:

* Abstracting the class instantiation process.
* Defining ways to create, compose, and represent objects 
and hide the implementation details from the involving 
system.
* Emphasizing avoiding hard code of a fixed set of 
behaviors and defining a smaller set of core behaviors 
instead, which can compose into any number of (complex) 
sets.

Creational design patterns have two basic characteristics:

1. Encapsulate knowledge about which concrete class the 
system use.
2. Hide how the instances of these classes are created 
and put together.

### Factory Method (Virtual Constructor)

To Create a Factory:
1. Create an Interface.
2. Implement Factory class.
3. Create a Factory Implementation to return an Object based on the parameters 
or conditions.

**Factory Interface**
```Java
public interface Factory {
    String getProduct();
}
```

**Factory Objects**
```Java
public class Bicycle implements Factory {
    public String getProduct() {return "Go go pedal!";}
}

public class Car implements Factory {
    public String getProduct() {return "I'm a Car.";}
}

public class Train implements Factory {
    public String getProduct() {return "I'm a Train Motherfucker!";}
}
```

**Factory implementation**
```java
public class TransportFactory {

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
```

### Abstract Factory (Kit)

### Builder

### Prototype

### Singleton

**Lazy Singleton**

```Java
public class LazySingleton {
    
    // 1. An static atribute for the instance.
    private static LazySingleton instance;
    
    // 2. Constructor Must be private
    private LazySingleton() {
        // Init code goes here
    }
    
    // 3. getInstance method to create the singleton
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

**Thread Safe Singleton**

```Java
public class ThreadSafeSingleton {
    
    // 1. An static atribute for the instance.
    private static ThreadSafeSingleton instance;
    
    // 2. Constructor Must be private
    private ThreadSafeSingleton() {
        // Init code goes here
    }
    
    // 3. getInstance method to create the singleton
    // Get the instance of the class with double checked locking
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
}
```

View Examples Java files [here](./creational/singleton/).

## Structural Design Patterns

The structural patterns provide guidelines to compose 
classes and objects to form a larger structure in 
accordance with the Object Oriented design principles.

It uses inheritance to compose interfaces or 
implementations, and recommends ways to compose objects 
and realize the new functionality.

Some focus areas are:

* Providing a uniform abstraction of different interfaces 
(Adapter).
* Changing the composition at runtime and providing 
flexibility of object composition; otherwise, it is 
impossible with static class composition.
* Ensuring efficiency and consistency by sharing objects.
* Adding Objects responsibility dynamically.

### Adapter Class (Wrapper)

### Adapter (Object)

### Bridge (Handle/Body)

### Composite

### Decorator

### Facade

### Flyweight

### Proxy

## Behavioral Patterns

Behavioral patterns provide guidelines on assigning 
responsibilities between objects. It does help with 
ways to implement algorithms and with communication 
between classes and objects.

It focuses on the following characteristics:

* Communication between objects and classes.
* Characterizing the complex control flow; flow of 
control in software programming (otherwise, it is hard 
to follow at runtime).
* Enforcing object composition rather than inheritance.
* Loose coupling between the peer objects, and at the 
same time, they know each other (by indirections).
* Encapsulating the behavior in an object and delegating 
request to it.

### Chain of Responsibility

### Command (Action/Transaction)

### Interpreter

### Iterator (Cursor)

### Mediator

### Memento

### Observer (Dependents/Publish/Subscribe)

### State (Objects for States)

### Strategy (Policy)

### The template method

### Visitor

