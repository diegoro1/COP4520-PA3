# COP4520-PA3

## Running Both Programs

Use the make file to run either program

For P1:
```bash
make p1
```

For P2:
```bash
make p2
```

## Approach
### P1
The minotaur has a "chain" of presents with random ids. This chain is simulated by a list of shuffled ids. Each of the four threads, or servents, will handle a quarter of that list. The thank you card simulation is done once the Thread places the id into the concurrent LinkedList. 

This concurrent linked list is a coarse-grained synchronized LinkedList that uses locks to prevent other treads from causing deadlocks and/or mismanaging the data. The problem with this approach is the locks themselves since the whole list becomes locked whenever adding or deleting a node, hence the horrible average run time of 7 minutes.  

A much better approach would be the use of a lazy synchronized linked list or any other variant that does not block the entire list or just blocks the node currently being worked on. 

The end result after running P1 would be a sorted LinkedList with all the presents from id 0 to 500,000. 
![Screen Shot 2022-04-13 at 11 55 45 PM](https://user-images.githubusercontent.com/47160221/163310766-2d5d31b7-3ccc-45d7-8289-226149267188.png)

### P2
Each sensor runs in a never-ending loop continuously getting a random reading of an integer ranging from -100 to 70. The reading is then placed in a concurrent linked list (similar to the one used in P1) while also adding the current interval. Intervals are incremented by a given frequency passed to each sensor thread. This frequency is hardcoded in the main function within P2.java and it is set by default to be 1 second to speed up the data reading process. Changing this variable to 60 would make sensors read every 1 minute and the logger to log the data every 10 minutes. 

The linked list keeps the data in a sorted manner, therefore, getting the top 5 values is done by traversing the list until the last 5 values are reached. These values are then sorted from greatest to smallest by the logger for better readability. The same thing is done for the bottom 5 readings, just traverse the first 5 nodes to get the data.
![Screen Shot 2022-04-14 at 12 18 33 AM](https://user-images.githubusercontent.com/47160221/163312851-8d201ec9-96ba-44cd-bb46-b6e66fdf90e9.png)

