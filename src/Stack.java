/**
 * This class is used to create Stack objects for
 * Project3.java. It implements Singly Linked Lists, using
 * classes Link and LinkedList. It has push and pop methods 
 * that allow for the insertion and removal of countries 
 * from the stack. It also has a method that will print
 * the stack to the console.
 * 
 * @author Hailey Francis
 * @version October 21, 2019
 *
 */
public class Stack {
	
	private LinkList list = new LinkList();
	
	/**
	 * -- CONSTRUCTOR --
	 */
	public Stack() {
	}
	
	/**
	 * Pushes new country onto stack top of stack, using insertFirst
	 * method from LinkedList class.
	 * 
	 * @param newCountry -- country to be pushed onto stack
	 */
	public void push(Country newCountry) {
		list.insertFirst(newCountry);
	}
	
	/**
	 * Pops country off from top of stack, using deleteFirst method
	 * from the LinkedList class.
	 * 
	 * @return Country that was popped off
	 */
	public Country pop() {
		return list.deleteFirst().country;
	}
	
	/**
	 * Returns true if the stack is empty. It uses
	 * the isEmpty() method from the LinkedList class.
	 * 
	 * @return true if stack is empty, false if not
	 */
	public boolean isEmpty() {
		return (list.isEmpty());
	}
	
	/**
	 * Returns false always, showing that the stack
	 * can never be full, since a linked list is used.
	 * 
	 * @return false always
	 */
	public boolean isFull() {
		return false;
	}
	
	/**
	 * Prints stack contents to console, using the displayList()
	 * method in the LinkedList class.
	 * 
	 */
	public void printStack() {
		System.out.println("\nStack Contents: ");
		System.out.println("Name                              Code                Capital                  Population                GDP                           HappinessRank ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------ ");
		list.displayList();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------ ");
	}
} //end Stack

/**
 * This is a manual implementation of the Link class to be used in Stack.java,
 * primarily in the LinkedList class that is also in Stack.java. It stores a 
 * Country object, as well as a Link called "next" which is to identify what
 * Link is next in the linked list. There's also a displayLink() method, which
 * will be used to display countries in the linked list when it is printed to the console.
 * 
 * @author Hailey Francis
 *
 */
class Link{
	
	public Country country;
	public Link next;
	
	/**
	 * -- LINK CONSTRUCTOR --
	 * @param newCountry -- country to be stored in Link
	 */
	public Link(Country newCountry) {
		country = newCountry;
	}
	
	/**
	 * Prints out information for Country in Link on one line.
	 * It is used in the displayList() method in the LinkedList
	 * class, to then be used in the printStack() method in the Stack class.
	 * 
	 */
	public void displayLink() {
		System.out.printf("%-35s", country.getName());
		System.out.printf("%-20s", country.getCode());
		System.out.printf("%-25s", country.getCapital());
		System.out.printf("%-25s", country.getPopulation());
		System.out.printf("%-30s", country.getGDP());
		System.out.println(country.getRank());
	}
} // end Link

/**
 * This is a manual implementation of the Linked List class.
 * It has methods that identify if the Linked List is empty,
 * as well as inserting and deleting the first link from the
 * list, and a displayList method that prints out all of the
 * links in the linked list.
 * 
 * @author Hailey Francis
 *
 */
class LinkList{
	
	private Link first;
	
	/**
	 *  -- LINKLIST CONSTRUCTOR --
	 */
	public LinkList() {
		first = null;
	}
	
	/**
	 * Returns true if the Linked List is empty. If
	 * First is null, that means the linked list is empty
	 * 
	 * @return true if first is null, false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Inserts new Link at the beginning of the Linked list. It
	 * takes a Country as a parameter, and then creates a new Link
	 * with that Country. It assigns the new link's next variable as
	 * the previous first link, then assigning the new Link to first.
	 * 
	 * @param newCountry -- Country to be stored in new Link
	 */
	public void insertFirst(Country newCountry){
		Link newLink = new Link(newCountry);
		newLink.next = first;
		first = newLink;
		
	}
	
	/**
	 * Deletes the first link from linked list. If the Linked list
	 * is empty, it returns first, which will be null if the list is
	 * empty. If it's not empty, it will assign first.next (the link after
	 * first) as first, and return the previous first.
	 * 
	 * @return -- Link being deleted.
	 */
	public Link deleteFirst() {
		if(!(isEmpty())) {
			Link temp = first;
			first = first.next;
			return temp;
		}else {
			System.out.println("The LinkedList in Stack is empty.");
			return first;
		}
	}
	
	/**
	 * Prints out all Links from Linked List into console, using a while loop.
	 * Used in the printStack() method. Prints in order of first to last.
	 * 
	 */
	public void displayList() {
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		
	}
} //end LinkList