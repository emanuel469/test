package models;

import java.util.Iterator;

public interface SortedList<E extends Comparable<E>> extends Iterable<E>{


	/*Adds a new element to the list in the right order The method
	traverses the list, looking for the right position for obj.
	 * @param obj element to be added to the DLL
	 */
	public boolean add(E obj);

	/*	returns the number of elements in the list. 
	 * current size
	 * */
	public int size();

	/*	removes the first occurrence of object from the list. Returns
	 *true if erased, or false otherwise.
	 * @return if the object that was removed
	 * @param obj to be removed on the first appereance
	 */
	public boolean remove(E obj);

	/*	removes the elements at position index. Returns true
	 *if the element is erased, or an IndexOutBoundsException if index is illegal.
	 * @param int index to be removed
	 * @return return boolean if value is removed or not
	 */
	public boolean remove(int index);

	/*
	 *removes all copies of element obj, and returns the number
	 *of copies erased.
	 * @param E obj to be remove
	 * @return int removed count
	 */
	public int removeAll(E obj);
	/*
	 * returns the first (smallest) element in the list, or null if the list is empty.
	 *  @return E value of the first node of the DLL
	 */
	public E first();

	/*
	 * returns the last (largest) element in the list, or null if the list is empty.
	 * @return E value of the last node of the DLL
	 */
	public E last();
	/*
	 * returns the elements at position index, or an
	 * IndexOutBoundsException if index is illegal.
	 * @param index node to be returned
	 * @return E element at the specific node
	 */
	public E get(int index);
	/*
	 * removes all elements in the list.
	 */
	public void clear();
	/*
	 * returns true if the element e is in the list or false otherwise.
	 * @param E element to compare
	 * @return if it is on the DLL or not
	 */
	public boolean contains(E e);
	/*
	 * returns true if the list is empty, or false otherwise.
	 * return boolean 
	 */
	public boolean isEmpty();
	/*
	 * Returns a forward iterator from position index, or
	 *an IndexOutBoundsException if index is illegal.
	 *@param int index to start interation]
	 *@return Iterator 
	 */
	public Iterator<E> iterator(int index);
	/*
	 * returns the index (position) of the first position of element e in
	 *the list or -1 if the element is not present.
	 *@param element to verify its first index
	 *@return Iterator 
	 */
	public int firstIndex(E e);
	/*
	 * returns the index (position) of the last position of element e in
	 *the list or -1 if the element is not present.
	 *@param element to verify its first index
	 *@return int 
	 */
	public int lastIndex(E e);
	/*
	 * returns a reverse iterator, starting from the
	 *last element in the list.
	 *ReverseIterator
	 */
	public ReverseIterator<E> reverseIterator();
	/*
	 * returns a reverse iterator, starting
	 *from position index in the list, or an IndexOutBoundsException if index is illegal.
	 *@return ReverseIterator 
	 */
	public ReverseIterator<E> reverseIterator(int index);

}
