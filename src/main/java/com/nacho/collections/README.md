# Technical Interview

## The Technical Phone Interview will include: 
* A coding exercise via [Codebunk](https://codebunk.com). 
* Algorithmic thinking.
* CS concepts.
* Data structure knowledge.
* Design patterns.
* Familiarity with arrays, lists, hash maps, graphs and tree traversals, etc. 

```java
// Initializing Arrays
String[] stringArray = new String[10];
String[] names = {"Nacho", "Alex", "Juan", "Simon"};

// Bidimentional Array
int biNumbers[][] = { {1, 2, 3}, {10,4}, {5,6} };

// Print 10
System.out.println(biNumbers[1][0]);

// Print everything
for (int[] nums : biNumbers) {
    for (int n: nums) {
        System.out.println(n);
    }
}

// Initializing List
List<String> list = new ArrayList<>();

list.add("Nacho");
list.add("Alex");
list.add("Juan");
list.add("Simon");

// Iterate list
for(String n : list) {
    System.out.println(n);
}

// Maps
Map<Integer, String> map = new HashMap<>();

map.put(1, "Nacho");
map.put(2, "Alex");
map.put(3, "Juan");
map.put(4, "Simon");

// Prints "Alex"
System.out.println(map.get(2));

// Iterate a Map
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " | " + entry.getValue());
}



```


## Helpful tips: 
As you code, explain your thought process out loud; articulate your working solution - 
even if it feels inefficient - and then iterate rather than immediately trying to jump 
to the clever solution. 

If the interviewer gives you hints to improve your code, take them and run with them. 
It is good to adjust and work through the problem with the interviewer to show your 
thought process and problem-solving ability. 

Be prepared with questions of your own. Be prepared to answer questions surrounding 
your interest in Pandora as a company – familiarizing yourself with our technical 
environment, technical challenges (via online research), can be helpful. 
Your familiarity with our app, your enthusiasm about Pandora, etc. are all taken 
into consideration. 