## Homework 4 - Week 4

### Motivation
* Demonstrate your ability to program using inheritance in the Java programming language.
* Demonstrate your knowledge of proper `equals` and `hashCode` implementations in the Java programming language.
* Demonstrate your knowledge of variable arguments and enum types in the Java programming language.

### Instructions
* There are four tasks to complete
    - Create an object hierarchy which mimics the classification of a [cactus](https://en.wikipedia.org/wiki/Cactus).
        - The hierarchy should be contained within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - There should be a base class called [Cactus](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Cactus.java)
        - There should be the following subtypes:
            - [Armatocereus](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Armatocereus.java)
            - [Ferocactus](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Ferocactus.java)
            - [Opuntia](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Opuntia.java)
            - [Turbinicarpus](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Turbinicarpus.java)
            - [Coryphantha](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Coryphantha.java)
            - [Ortegocactus](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Ortegocactus.java)
            - [Pereskia](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Pereskia.java)
            - [Stetsonia](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Stetsonia.java)
            - [Consolea](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Consolea.java)
        - Create an enum named [LeafType](src/main/java/edu/nyu/cs9053/homework4/hierarchy/LeafType.java) which is one of;
            - Leaf
            - Spine
        - Each of the subtypes should have the following methods:
            - `isFlowering` which returns a boolean indicating whether the cactus produces flowers
            - `getLeafType` which returns a [LeafType](src/main/java/edu/nyu/cs9053/homework4/hierarchy/LeafType.java)
            - `hasEdibleFruit` which returns a boolean indicating whether the cactus produces a fruit which is edible
            - `getName` returns a name for the cactus. This value is per object and not defined by the class
            - `getLocation` returns a `String` type describing its location (e.g. Florida). This value is per object and not defined by the class. You do not need to ensure this value is accurate when constructed.
        - For each class which has no sub-types itself, add a property to the class particular to the type which is also used in the `equals` and `hashCode` methods.
        - Try to limit code by sharing across classes. This can include composition where you create another object hierarchy which your [Cactus](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Cactus.java) implementations leverage.
    - Provide implementations of the `equals` and `hashCode` methods for each class within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - Note, these methods are testing equality and returning hashes for the objects and so should only include checks on type information and object specific values.
        - Note, do not use Objects helper class, write your own implementations.
    - Create an enum type representing the [10 major deserts](https://en.wikipedia.org/wiki/Desert) in the world;
        - Each desert must also have a method returning its area in kilometers squared, name it `getAreaKm`.
        - The enum should be called [Desert](src/main/java/edu/nyu/cs9053/homework4/Desert.java) with package `edu.nyu.cs9053.homework4`
    - Create a static varargs method within [Desert](src/main/java/edu/nyu/cs9053/homework4/Desert.java) which takes a variable number of Desert objects and prints each object's area.

### Implementation
* You are encouraged to make more classes then those I have listed to properly organize/classify your hierarchy
* Ensure your code is correct by compiling it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    