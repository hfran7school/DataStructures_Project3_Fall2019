# DataStructures_Project3_Fall2019
COP 3538: Project 3 -- Linked Lists
 * @author Hailey Francis (n01402670@unf.edu)
 * @version October 21, 2019

Project3.java
 * This class creates a Stack using Stack.java (which implements Linked List) and
   a Queue using Queue.java (which implements a Doubly Linked List).
 * The program first creates Country objects one at a time from the Countries.csv
   file, (in this case Countries3.csv). The Countries are placed in the Stack if they have
   a GDP per capita between 1,000 <= GDPperCapita < 50,000. As listed in our rubric, these Countries
   are considered in the FAIR, GOOD, and VGOOD categories. 
 * After being placed in the Stack, the program prints the Stack to the console, front to end.
   Then, the Countries are popped from the stack and then inserted into the Queue, alternating
   between inserting at the front and end of the queue. The program then prints the Queue to the console,
   front to end.
 * Then, Countries that have a GDP per capita between 30,000 and 40,000 are removed from the Queue. After
   they are removed, the Queue is printed to the console again.
 * The Countries are then removed from the queue, alternating removing from the front and end, and are
   pushed back onto the Stack. The Stack is then once again printed to the console. After that, the program ends.

Stack.java
 * This class is used to create Stack objects for
   Project3.java. It implements Singly Linked Lists, using
   classes Link and LinkedList. It has push and pop methods 
   that allow for the insertion and removal of countries 
   from the stack. It also has a method that will print
   the stack to the console.
 
Queue.java
 * This class is used to create Queue objects in Project3.java.
   It implements Doubly Linked Lists, using classes DoubleLink and
   DoublyLinkedList. It has methods that allow the user to insert and remove
   from the fronts and ends of the array, as well as a findDelete method that
   will delete a Country from the queue if it finds the key by name. It also
   has a method to print out the queue.
   
Country.java
 * This class is to make Country objects for Project1.java,
   and is now being used for Project 3. It includes getter and setter methods, 
   as well as a method that calculates the GDP, a method that compares Country
   objects by their names, and a method that prints the information
   about a Country object.
 * This is the same Country.java seen both in my Data Structures Projects 1 and 2
   repositories.
