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
