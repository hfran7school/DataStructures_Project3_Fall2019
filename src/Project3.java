/**
 * COP 3538: Project 3 -- Linked Lists
 * <p>
 * This class creates a Stack using Stack.java (which implements Linked List) and
 * a Queue using Queue.java (which implements a Doubly Linked List).
 * <p>
 * The program first creates Country objects one at a time from the Countries.csv
 * file, (in this case Countries3.csv). The Countries are placed in the Stack if they have
 * a GDP per capita between 1,000 <= GDPperCapita < 50,000. As listed in our rubric, these Countries
 * are considered in the FAIR, GOOD, and VGOOD categories. 
 * <p>
 * After being placed in the Stack, the program prints the Stack to the console, front to end.
 * Then, the Countries are popped from the stack and then inserted into the Queue, alternating
 * between inserting at the front and end of the queue. The program then prints the Queue to the console,
 * front to end.
 * <p>
 * Then, Countries that have a GDP per capita between 30,000 and 40,000 are removed from the Queue. After
 * they are removed, the Queue is printed to the console again.
 * <p>
 * The Countries are then removed from the queue, alternating removing from the front and end, and are
 * pushed back onto the Stack. The Stack is then once again printed to the console. After that, the program ends.
 * 
 * @author Hailey Francis (n01402670)
 * @version October 21, 2019
 *  
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project3 {

	/**
	 * -- MAIN METHOD --
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String fileName;
		Stack STACK = new Stack();
		Queue QUEUE = new Queue();
		
		System.out.println("COP3538 Project 3");
		System.out.println("Instructor: Xudong Liu\n");
		
		System.out.println("Linked Lists");
		System.out.print("Enter the file name: ");
		fileName = input.next();
		input.close();
		
		// create, fill, and print stack //
		readFile(fileName, STACK);
		STACK.printStack();
		
		// move countries from stack to queue //
		System.out.println("\n(Countries moved to Queue)");
		moveToQueue(STACK, QUEUE);
		QUEUE.printQueue();
		
		// remove countries with GDP per capita between 30,000 - 40,000 //
		System.out.println("\n(Removed countries with GDP 30,000 - 40,000)");
		removeThirtytoFourty(QUEUE);
		QUEUE.printQueue();
		
		// move countries back to stack //
		System.out.println("\n(Moved countries back to Stack)");
		moveToStack(STACK, QUEUE);
		STACK.printStack();
		
		
		
		
	}//end main
	
	/**
	 * Collects data from Countries.csv file (in this case Countries3.csv), creating
	 * Country objects from the data provided, one at a time. If the Country is considered
	 * FAIR, GOOD, or VGOOD, as stated in the comment for the Project3.java class, it is
	 * pushed onto the stack.
	 * 
	 * @param fileName -- name of file provided by user
	 * @param stack -- stack object to contain countries
	 */
	public static void readFile(String fileName, Stack stack) {
		String name, code, capital; 
		int population, rank;
		double GDP; // doubles will all be read as exponentials
		Scanner r;
		// OPENING FILE //
		try {
			r = new Scanner(new File(fileName));
			r.useDelimiter("\\,|\r\n|\n");
		    // READING FILE //
			for(int i = 0; i < 6; i++) { //meant to cycle through first line of file, which presumably is labels such as in Countries1.csv and Countries2.csv
				r.next();
			}
			while(r.hasNext()) { //assigns values from file to variables, then forming Country object added to priority queues
				name = r.next();
				code = r.next();
				capital = r.next();
				population = r.nextInt();
				GDP = r.nextDouble();
				rank = r.nextInt();
				
				Country temp = new Country(name, code, capital, population, GDP, rank); //creates new country
				if(temp.calcGDPperCapita() >= 1000 && temp.calcGDPperCapita() < 50000) { //pushes country onto stack if FAIR, GOOD, or VGOOD
					stack.push(temp);
				}
			}
		}catch(InputMismatchException i) {
			System.out.println("Input Mismatch Exception. Program likely tried assigning value to wrong variable due to format of file.");
		}catch(NumberFormatException j) {
			System.out.println("Number format exception. Program likely tried assigning value to wrong variable due to format of file.");
		}catch(FileNotFoundException e) {
			System.out.println("File not found. "
				+ "Please make sure you entered the name of the file correctly "
				+ "and that the file is accessable the next time you run this program.\n"
				+ "(This project was submitted with a file called Countries2.csv.) [This error was thrown by the readFile method]");
		}catch(NullPointerException n) {
			System.out.println("Null pointer exception in readFile");
		}
	}//end readFile
	
	/**
	 * Moves Countries from Stack to Queue. Pops countries from Stack and
	 * alternates between inserting the Country at the front and the end of
	 * the Queue.
	 * 
	 * @param stack -- stack of countries
	 * @param queue -- queue for countries
	 */
	public static void moveToQueue(Stack stack, Queue queue) {
		Country temp;
		int counter = 0;
		while(!stack.isEmpty()) {
			temp = stack.pop();
			if(counter % 2 == 0) {
				queue.insertFront(temp);
			}else {
				queue.insertEnd(temp);
			}
			counter++;
		}
	}//end moveToQueue
	
	/**
	 * Removes countries from queue that have GDP per capita
	 * between 30,000 and 40,000. It uses the findDelete method from
	 * Queue.java. The findDelete method uses the name of the Country
	 * as its key, so if a Country has a GDP per capita within the
	 * range of 30,000 - 40,000, it uses that Country's name as a 
	 * parameter to delete it from the queue. Since the findDelete
	 * method was required to return a boolean value, the program tell the user
	 * if the Country somehow did not get deleted if that boolean value is false.
	 * 
	 * @param queue -- queue for countries
	 */
	public static void removeThirtytoFourty(Queue queue) {
		DoubleLink current = queue.getDoublyLinkedList().getFirst();
		while(current != null) {
			Country temp = current.country;
			if(temp.calcGDPperCapita() >= 30000 && temp.calcGDPperCapita() <= 40000) {
				boolean deleted = queue.findDelete(temp.getName());
				if(!deleted) {
					System.out.println(temp.getName() + " was not deleted. GDPperCapita = " + temp.calcGDPperCapita());
				}
			}
			current = current.next;
		}
	}//end removeThirtytoFourty
	
	/**
	 * Moves items from Queue to Stack. Alternates between removing from
	 * the front and end of the Queue, and pushes those countries on to the
	 * Stack.
	 * 
	 * @param stack -- stack of countries
	 * @param queue -- queue for countries
	 */
	public static void moveToStack(Stack stack, Queue queue) {
		Country temp;
		int counter = 0;
		while(!queue.isEmpty()) {
			if(counter % 2 == 0) {
				temp = queue.removeFront();
			}else {
				temp = queue.removeEnd();
			}
			counter++;
			stack.push(temp);
		}
	}//end moveToStack
}
