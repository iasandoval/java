# BANK

## Problem 1
* Map with Names and age. Same person with multiple age
* Get the top 3 stocks value

## Problem 2
* Swap values without creating a 3rd variable

````Java
int a = 4;
int b = 7;

// Solution
a = a + b; // a = 11
b = a - b; // b = 11-7 = 4
a = a - b; // a = 11-4 = 7
````

* Find the intersection of 2 sets

````Java
// A = {2, 3, 4}
// B = {6, 4, 3, 8}

final Set<Integer> A = new HashSet<>(Arrays.asList(2,3,4));
final Set<Integer> B = new HashSet<>(Arrays.asList(6,4,3,8));

Set<Integer> intersection = new HashSet<>();

for(int a : A) {
    if(B.contains(a)) {
        intersection.add(a);
    }
}

intersection.forEach((v) -> {System.out.println(v);});

````

* Based on a Stack, determine the highest value in the stack 
with O(1) complexity.
```Java

// PUSH (1) -> Largest is 1
// PUSH (5) -> Largest is 5
// PUSH (5) -> Largest is 5
// PUSH (7) -> Largest is 7
// PUSH (8) -> Largest is 8
// POP ()   -> Largest is 7

class MyStack extends Stack<Integer> {

    private LinkedList<Integer> list;
    private Integer max;

    public MyStack() {
        super();
        this.list = new LinkedList<>();
        this.max = 0;
    }

    @Override
    public Integer push(Integer item) {

        if(item > this.max) {
            this.max = item;
            this.list.add(item);
        }

        System.out.println("Max = " + this.max);

        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {

        Integer pop = super.pop();

        if (pop == this.max) {
            this.list.removeLast();
            this.max = this.list.getLast();
        }

        System.out.println("Max = " + this.max);

        return pop;
    }

}

```

* Based in a Binary Search Tree, find the nearest root for a given Node and value.

```Java
public void findNearestRoot(Node n, int value) {
    
    
    
    
}
```



