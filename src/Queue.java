/**
 * This class is used to create Queue objects in Project3.java.
 * It implements Doubly Linked Lists, using classes DoubleLink and
 * DoublyLinkedList. It has methods that allow the user to insert and remove
 * from the fronts and ends of the array, as well as a findDelete method that
 * will delete a Country from the queue if it finds the key by name. It also
 * has a method to print out the queue.
 * 
 * @author Hailey Francis (n01402670)
 * @version October 21, 2019
 */
public class Queue {

	private DoublyLinkedList doublylinkedlist = new DoublyLinkedList();
	
	/**
	 * -- CONSTRUCTOR --
	 */
	public Queue(){
	}
	
	/**
	 * Inserts Country at the front of the queue, using the
	 * insertFirst method from the DoublyLinkedList class.
	 * 
	 * @param newCountry -- Country to be inserted
	 */
	public void insertFront(Country newCountry) {
		doublylinkedlist.insertFirst(newCountry);
	}
	
	/**
	 * Inserts Country at the end of the queue, using the
	 * insertLast method from the DoublyLinkedList class.
	 * 
	 * @param newCountry -- Country to be inserted
	 */
	public void insertEnd(Country newCountry) {
		doublylinkedlist.insertLast(newCountry);
	}
	
	/**
	 * Removes Country at the front of the queue, using the
	 * deleteFirst method from the DoublyLinkedList class.
	 * 
	 * @return Country that has been removed
	 */
	public Country removeFront() {
		return doublylinkedlist.deleteFirst().country;
	}
	
	/**
	 * Removes Country at the end of the queue, using the
	 * deleteLast method from the DoublyLinkedList class.
	 * 
	 * @return Country that has been removed
	 */
	public Country removeEnd() {
		return doublylinkedlist.deleteLast().country;
	}
	
	/**
	 * This method is given a string, which represents the name of
	 * the Country. It uses the deleteKey method from the DoublyLinkedList
	 * class. If the Country is found, the method will return true, and the
	 * Country will be removed. It will return false if the Country is not found.
	 * 
	 * @param CountryNameKey -- name of Country for key
	 * @return true if Country found, false if not
	 */
	public boolean findDelete(String CountryNameKey) {
		DoubleLink found = doublylinkedlist.deleteKey(CountryNameKey);
		if(found == null) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Will return true if the DoublyLinkedList is empty. Uses the
	 * isEmpty method from the DoublyLinkedList class.
	 * 
	 * @return true if doublyLinkedList is empty, false if not
	 */
	public boolean isEmpty() {
		return doublylinkedlist.isEmpty();
	}
	
	/**
	 * Will always return false, since a LinkedList can never technically
	 * be full. Meant to show if Queue is full or not.
	 * 
	 * @return false, because queue never full because DoublyLinkedList in use.
	 */
	public boolean isFull() {
		return false;
	}
	
	/**
	 * getter method for doublylinkedlist
	 * 
	 * @return doublylinkedlist
	 */
	public DoublyLinkedList getDoublyLinkedList() {
		return doublylinkedlist;
	}
	
	/**
	 * Prints queue to console, using the displayDoublyLinkedList method
	 * from the DoublyLinkedList class.
	 */
	public void printQueue() {
		System.out.println("\nQueue Contents: ");
		System.out.println("Name                              Code                Capital                  Population                GDP                           HappinessRank ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------ ");
		doublylinkedlist.displayDoublyLinkedList();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------ ");
	}
	
} //end Queue

/**
 * This class is used in DoublyLinkedList, creating DoubleLinks to link
 * Countries together in the list. It contains a Country object, as well as the
 * link before it and after it. It also has a method to display its Country information.
 * 
 * @author Hailey Francis
 *
 */
class DoubleLink{
	
	public Country country;
	public DoubleLink previous;
	public DoubleLink next;
	
	/**
	 * -- DOUBLELINK CONSTRUCTOR --
	 * 
	 * @param newCountry -- Country data to be added to DoubleLink
	 */
	public DoubleLink(Country newCountry) {
		country = newCountry;
	}
	
	/**
	 * Prints the DoubleLink's Country Data in a format for later printing to the console.
	 */
	public void displayDoubleLink() {
		System.out.printf("%-35s", country.getName());
		System.out.printf("%-20s", country.getCode());
		System.out.printf("%-25s", country.getCapital());
		System.out.printf("%-25s", country.getPopulation());
		System.out.printf("%-30s", country.getGDP());
		System.out.println(country.getRank());
	}
	
} //end DoubleLink

/**
 * This is the manual implementation of the DoublyLinkedList for Queue.java.
 * It contains multiple methods that inserts and deletes DoubleLinks from the list,
 * with these DoubleLinks containing Country data. There is also a deleteKey method, which
 * deletes the link based on the key, which is its Country's name. There is a displayLinkedList
 * method that uses the displayDoubleLink method, to print all of the DoubleLinks' Country data
 * to the console. 
 * 
 * @author Hailey Francis
 *
 */
class DoublyLinkedList{
	
	private DoubleLink first;
	private DoubleLink last;
	
	/**
	 * Returns true if the doubly linked list is empty.
	 * If first is null, then that means the list is empty.
	 * 
	 * @return true if first is null, false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Inserts DoubleLink, making it first in the doubly Linked List.
	 * @param newCountry
	 */
	public void insertFirst(Country newCountry) {
		DoubleLink newLink = new DoubleLink(newCountry);
		if(isEmpty()) {
			last = newLink;
		}else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	/**
	 * Inserts DoubleLink, making it last in the doubly linked list.
	 * @param newCountry
	 */
	public void insertLast(Country newCountry) {
		DoubleLink newLink = new DoubleLink(newCountry);
		if(isEmpty()) {
			first = newLink;
		}else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}
	
	/**
	 * Deletes the first DoubleLink in the doubly linked list, returning
	 * it to the user.
	 * 
	 * @return DoubleLink that was deleted
	 */
	public DoubleLink deleteFirst() {
		DoubleLink temp = first;
		if(first.next == null) {
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
	
	/**
	 * Deletes the last DoubleLink in the doubly linked list,
	 * returning it to the user.
	 * 
	 * @return DoubleLink that was deleted
	 */
	public DoubleLink deleteLast() {
		DoubleLink temp = last;
		if(first.next == null) {
			first = null;
		}else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	
	/**
	 * Deletes DoubleLink based on the name of the Country
	 * contained in the DoubleLink. It will return that DoubleLink
	 * if it is found, and if it is not found, it will return null.
	 * 
	 * @param key -- name of Country to be found so associated DoubleLink is deleted
	 * @return DoubleLink that was deleted
	 */
	public DoubleLink deleteKey(String key) {
		DoubleLink current = first;
		while(!current.country.getName().equals(key)) {
			current = current.next;
			if(current == null) {
				return null;
			}
		}
		if(current == first) {
			first = current.next;
		}else {
			current.previous.next = current.next;
		}
		if(current == last) {
			last = current.previous;
		}else {
			current.next.previous = current.previous;
		}
		return current;
	}
	
	/**
	 * Displays Doubly Linked list by cycling through
	 * the Doubly Linked List through a while loop and using
	 * the displayDoubleLink method to display each invididual
	 * DoubleLink from the list.
	 * 
	 */
	public void displayDoublyLinkedList() {
		DoubleLink current = first;
		while(current != null) {
			current.displayDoubleLink();
			current = current.next;
		}
	}
	
	/**
	 * getter method for first, since first is a
	 * private variable in DoublyLinkedList.
	 * 
	 * @return DoubleLink first
	 */
	public DoubleLink getFirst() {
		return first;
	}
	
} //end DoublyLinkedList
