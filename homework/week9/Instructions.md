## Homework 9 - Week 9

### Motivation
* Demonstrate your ability to program using Java semaphores.

### Instructions
* You have one task to complete:
* Finish the vending machine dispenser system. This is a version of the producer / consumer problem.
    - Create an implementation of the [Consumer](src/main/java/edu/nyu/cs9053/homework9/Consumer.java)
    - Create an implementation of the [Producer](src/main/java/edu/nyu/cs9053/homework9/Producer.java)
    - Complete the factory which instantiates your implementations [ProducerConsumerFactory](src/main/java/edu/nyu/cs9053/homework9/ProducerConsumerFactory.java)
        - You should only modify `ProducerConsumerFactory` and create your two implementations.
    - To ensure this portion of the assignment works you need to invoke the main class which is [VendingMachineDispenser](src/main/java/edu/nyu/cs9053/homework9/VendingMachineDispenser.java)
        - It should run forever

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
* You should not need to create any Thread objects, call sleep or join for this assignment. If you find yourself doing this you have done something wrong.    
    

    