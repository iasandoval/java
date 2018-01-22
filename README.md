# Study Guide for Java 8

## Introduction

### Required Software:

- [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Eclipse](https://www.eclipse.org)

### Theory is here:
- [Java 8 Tutorial](https://docs.oracle.com/javase/tutorial/java/TOC.html)

## Functional Programming

### Aspects of functional programming

  - Functions can be simple or complex
  - Simpler functions are preferred
  - Function should ideally not change the state of memory or perform I/O
  - Works with immutable data  

### Functions

First-class and high-order functions are associated with functional programming. A **first-class 
function** refers to functions that can be used anywhere a first-class entity can be used. 
A **first-class entity** includes elements such as number and strings. 
They can be used as an argument to a function, returned from a function, or assigned to a variable.

**High-order functions** depend upon the existence of first-class functions. They are 
functions that either:
  - Take a function as an argument
  - Return a function

**Lambda expressions** are anonymous functions that can be passed to and return from 
functions. They can also be assigned to a variable.

```Java
    // Basic form of lambda expression
    x -> 2*x
    // Parameter (x), Lambda operator (->), body (2*x)
```

Print the list values in separate lines
```Java
    Integer arr[] = {1,2,3,4,5};
    List<Integer> list = Arrays.asList(arr);
    
    // Print the list values in separate lines 
    list.forEach(x->System.out.println(x));
```

A **pure function** is a function that has no side effects. This means that memory external 
to the function is not modified, IO is not performed, and no exceptions are thrown.

**Referential transparency**, when a pure function it is called repeatedly with the same 
parameters, it will return the same value.

**Currying** is the process of evaluating multiple arguments of a function one-by-one, 
producing intermediate results.

### Function composition

Functions are not only used to organize the execution process, but are also passed 
and returned from functions. Often data and the functions acting on the data are 
passed together promoting more capable and expressive programs.

```Java
    Function<Integer, Integer> absThenNegate = ((Function<Integer, Integer>)Math::negateExact).compose(Math::abs);
        
    System.out.println(absThenNegate.apply(-25));
    System.out.println(absThenNegate.apply(25));
```

### Fluent Interfaces

Fluent interfaces constitute a way of composing expressions that are easier to write 
and understand. A fluent interface is often implemented using **method chaining** or also 
called **method cascading**, where the returned value is used again in the same context. 

```Java
    // Without method chaining
    LocalDate today = LocalDate.now();
    LocalDate futureDate = today.plusYears(2);
    futureDate = futureDate.minusMonths(1);
    futureDate = futureDate.plusDays(3);
        
    System.out.println(today);
    System.out.println(futureDate);
        
    // With method chaining
    LocalDate chainFutureDate = LocalDate.now()
                                    .plusYears(2)
                                    .minusMonths(1)
                                    .plusDays(3);
        
    System.out.println(chainFutureDate);
```

### Strict vs non-strict evaluation

**Strict Evaluation**
  - Also called eager evaluation
  - The expressions are evaluated as there are encountered

**Non-strict evaluation**
  - They are evaluated until necessary
  - Sometimes called lazy evaluation
  - Is supported using Streams.

```Java
    // Non-strict evaluation
    Random random = new Random();
    random.ints()   // Returns an IntStream instance
          .limit(5)
          .sorted()
          .forEach(x -> System.out.println(x));
```

### Recursion
A loop is used in an imperative language to perform repeated calculations.Recursion 
is a technique that can achieve the same effect but often in a more elegant manner. A 
function is recursive if it calls itself either directly or indirectly.

```Java
    // Without recursion
    int result = 1;
    for(int i = 5; i >= 1; i--) {
        result = result * i;
    }
        
    System.out.println(result);

    // Recursive Factorial method
    public static int factorial(int n) {
        if (n==1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // With Recursion
    System.out.println(factorial(5));
```

### Parallelism/Concurrent

The following code sequence illustrates how a lambda expression can be applied to each 
member of the stream.


