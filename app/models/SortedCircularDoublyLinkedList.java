package models;

import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * SortedCircularDoublyLinkedList implements SortedList<E>
 *
 */
public class SortedCircularDoublyLinkedList<E extends Comparable<E>> implements SortedList<E> {


	/**
	 * Private class for nodes
	 *
	 */
	private class Node {
		private E value;
		private Node next;
		private Node prev;

		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}

	/**
	 * Private class for a FW iterator
	 *
	 */
	private class ListIterator implements Iterator<E>{
		private Node nextNode;
//contructor 
		public ListIterator(){
			this.nextNode = header.getNext();
		}
		/**
		 * Contructor
		 *@param int 
		 */
		public ListIterator(int index){
			if((index < 0) || (index>currentSize))
				throw new IndexOutOfBoundsException();

			int counter = 0;
			Node temp;

			for(temp = header.getNext(); counter < index; temp = temp.getNext(), counter++);
			this.nextNode = temp;
		}
		/**
		 * If the list has a next returns true, else, false
		 *@return boolean  
		 */
		@Override
		public boolean hasNext() {
			return nextNode.getValue() != null;
		}
		/**
		 * If the list has a next returns next value 
		 *@return E 
		 */
		@Override
		public E next() {
			if (hasNext()){
				E result = this.nextNode.getValue();
				this.nextNode = this.nextNode.getNext();
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}	
	}
	/**
	 * Private class for a Reverse Iterator 
	 *
	 */
	private class ReverseListIterator implements ReverseIterator<E>{
		private Node prevNode;
		/**
		 *Contructor
		 */
		public ReverseListIterator(){
			this.prevNode = header.getPrev();
		}

		public ReverseListIterator(int index){
			int counter = currentSize;
			Node tempNode;

			for( tempNode = header.getPrev() ; counter > currentSize-index; tempNode = tempNode.getPrev(), counter--);
			this.prevNode = tempNode;
		}
		/**
		 * If the list has a previous returns true, else, false
		 *@return boolean  
		 */
		@Override
		public boolean hasPrevious() {
			return prevNode != header;
		}
		/**
		 * If the list has a previous returns next value 
		 *@return E 
		 */
		@Override
		public E previous() {
			if (hasPrevious()){
				E result = prevNode.getValue();
				prevNode = prevNode.getPrev();
				return result;
			}
			else {
				throw new NoSuchElementException();

			}

		}

	}


	/////////////////////////// Official class starts here/////////////

	Node header;
	int currentSize;

	//contructor
	public SortedCircularDoublyLinkedList(){
		header = new Node();
		header.setValue(null);
		header.setNext(header);
		header.setPrev(header);
		currentSize = 0;
	}

	//Iterator Method 
	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public boolean add(E obj) {
		if(obj == null)
			throw new IllegalArgumentException("Null argument");

		boolean added = false; 

		for(Node tempNode = header.getNext();tempNode.getValue()!= null; tempNode=tempNode.getNext()){
			if(obj.compareTo(tempNode.getValue()) < 0){
				Node tempNode2= new Node();
				if(tempNode.getPrev().getValue() == (header.getValue())) {
					tempNode2.setValue(obj);
					tempNode2.setNext(tempNode);
					tempNode2.setPrev(header);
					header.setNext(tempNode2);
					tempNode.setPrev(tempNode2);
				}

				else{
					tempNode2.setValue(obj);
					tempNode2.setNext(tempNode);
					tempNode2.setPrev(tempNode.getPrev());
					tempNode.getPrev().setNext(tempNode2);
					tempNode.setPrev(tempNode2);

				}
				added=true;
				currentSize++;
				return added;
			}
		}

		if(!added){
			Node temp = new Node();
			temp.setValue(obj);
			temp.setNext(header);
			temp.setPrev(header.getPrev());
			header.getPrev().setNext(temp);
			header.setPrev(temp);
			added=true;
			currentSize++;
		}
		return added;
	}
	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public boolean remove(E obj) {
		if(obj == null) throw new IllegalArgumentException("Null Parameter");

		for(Node temp = header.getNext(); temp.getValue() != null; temp = temp.getNext()){
			if(obj.compareTo(temp.getValue())==0){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				temp.setNext(null);
				temp.setPrev(null);
				temp.setValue(null);
				currentSize--;
				return true;
			}
		}
		return false;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public boolean remove(int index) {
		if((index < 0) || (index > this.currentSize)) throw new IndexOutOfBoundsException();

		int i = 0;
		for(Node temp = header.getNext(); temp.getValue()!=null; temp = temp.getNext(), i++){
			if(index == i){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				temp.setNext(null);
				temp.setPrev(null);
				temp.setValue(null);
				currentSize--;
				return true;
			}
		}
		return false;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public int removeAll(E obj) {
		int counter = 0;
		while(this.remove(obj)){
			counter++;
		}
		return counter;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getValue();
	}
	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public E last() {
		if(isEmpty())
			return null;
		return header.getPrev().getValue();
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public E get(int index) {
		if((index<0)||(index>this.currentSize)){
			throw new IndexOutOfBoundsException();
		}

		int counter = 0;
		for(Node temp = header.getNext(); temp.getValue()!=null; temp = temp.getNext(), counter++){
			if(counter == index)
				return temp.getValue();	
		}

		return null;
	}
	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public void clear() {
		while(!this.isEmpty()){
			this.remove(0);
		}
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public boolean contains(E e) {
		for(Node temp = header.getNext(); temp.getValue()!=null; temp = temp.getNext()){
			if(temp.getValue().compareTo(e)==0){
				return true;
			}
		}

		return false;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public boolean isEmpty() {
		return currentSize==0;
	}

	
	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public Iterator<E> iterator(int index) {
		return new ListIterator(index);
	}

	/*
	 * Look at SortedList.java for full documentation
	 */

	@Override
	public int firstIndex(E e) {
		int counter = 0;
		for(Node temp = header.getNext(); temp.getValue()!= null; temp = temp.getNext(),counter++){
			if(e.compareTo(temp.getValue())==0){
				return counter;
			}
		}

		return -1;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public int lastIndex(E e) {
		int counter = currentSize-1;
		for(Node temp = header.getPrev(); temp.getValue()!= null; temp = temp.getPrev(),counter--){
			if(e.compareTo(temp.getValue())==0){
				return counter;
			}
		}

		return -1;
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public ReverseIterator<E> reverseIterator() {
		return new ReverseListIterator();
	}

	/*
	 * Look at SortedList.java for full documentation
	 */
	@Override
	public ReverseIterator<E> reverseIterator(int index) {
		return new ReverseListIterator(index);
	}	


}
