/* * 
 * The PythonList is a collection extending ArrayList which allows for 
 * the Python style negative indices to be correctly handled. It extends the
 * ArrayList collection.
 * 
 * @author David Scott 
 * @date   <1/21/21> 
 * */

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;


@SuppressWarnings("serial")
public class PythonList<E> extends ArrayList<E>{
	
	public PythonList(){
		super();
	}
	
	public PythonList(Collection<? extends E> c) {
		super(c);
	}
	
	/**
	 * @param: Takes index of type integer where element E should be added in python list
	 */
	public void add(int index, E element) {
		int fixedIndex = this.standardizeIndex(index);
		
		super.add(fixedIndex, element);
	}
	
	/**
	 * Returns element of python list at index specified
	 * @param: Takes index of type integer of python list where element to be removed is
	 * @returns element of python list at index specified
	 */
	public E get(int index) {
		int fixedIndex = this.standardizeIndex(index);
		
		E temp = super.get(fixedIndex);
		return temp;
	}
	
	/**
	 * Returns element removed from python list at specified index
	 * @param: Takes index of python list of element to be removed
	 * @returns element removed from python list at specified index
	 */
	public E remove(int index) {
		int fixedIndex = this.standardizeIndex(index);
		
		E temp = super.remove(fixedIndex);
		return temp;
	}
	
	/**
	 * Returns element set in python list
	 * @param: index of type integer where element E will be placed
	 * @returns element set in python list
	 */
	public E set(int index, E element) {
		int fixedIndex = this.standardizeIndex(index);
		
		E temp = super.set(fixedIndex, element);
		return temp;
	}
	
	/**
	 * Returns returns a sublist from indices provided on pythonlist
	 * @param: takes both indices to make sublist
	 * @returns returns a sublist from indices provided on pythonlist
	 * @throws IllegalArgumentException if Java (positive) indices have fromIndex > toIndex.
	 */
	public PythonList<E> subList(int fromIndex, int toIndex) throws  IllegalArgumentException{
		int firstFixedIndex = this.standardizeIndex(fromIndex);
		int secondFixedIndex = this.standardizeIndex(toIndex);
		
		if (secondFixedIndex < firstFixedIndex) {
			throw new IllegalArgumentException();
		}
		List<E> tempList = super.subList(firstFixedIndex, secondFixedIndex);
		PythonList<E> pyList = new PythonList<E>(tempList);

		return pyList;
	}
	
	/**
	 * Method tests to see if index is in valid range of -L.size() ≤ index < L.size()
	 * Returns a boolean indicating if index passed range check
	 * @param: index of type integer to be checked
	 * @returns a boolean indicating if index passed range check
	 */
	private void rangeCheck(int index) throws IndexOutOfBoundsException{
		//Should throw throws IllegalArgumentException
		int tempSize = this.size();
		int lowerValid = tempSize * -1;
		int upperValid = tempSize - 1;
		
		if (!(lowerValid <= index && index <= upperValid && this.size() != 0)) {
			throw new IndexOutOfBoundsException("Indice provided is not valid.");
		}
	}
	
	/**
	 * Method standardizes negative python indices so they are compatible with java
	 * Returns the standardized index as an integer, if java index was provided, remains unchanged
	 * @param: index of type integer that needs to be standardized
	 * @returns the standardized index as an integer, if java index was provided, remains unchanged
	 * @throws IllegalArgumentException if list is empty or if lower bound is greater than higher bound
	 */
	private int standardizeIndex(int index){
		this.rangeCheck(index);
		
		int standardizedIndex;
		if (index >= 0) {
			return index;
		}
		
		standardizedIndex = index + this.size(); //Handles negative python indices
		return standardizedIndex;		
	}
}
