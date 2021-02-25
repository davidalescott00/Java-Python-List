/* * 
 * The PythonListTest is a series of methods testing the functionality of the PythonList object. 
 * Included are edge cases and normal cases, using standard and python indices.
 * @author David Scott 
 * @date   <1/28/21> 
 * */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PythonListTest {
	
	/* * 
	 * Utility method checking the equality of a pythonList and arraylist provided.
	 * Returns a boolean true if they are.
	 * @returns a boolean true if the two collections have equal elements.
	 * @param pyList of type PythonList and arrList of type ArrayList
	 * */
	private static <E> boolean equalCheck(PythonList<E> pyList, ArrayList<E> arrList) {
		
		if (pyList.size() != arrList.size()) {
			return false;
		}
		
		for (int i=0; i < pyList.size(); i++) {
			if (!(pyList.get(i).equals(arrList.get(i)))) {
				return false;
			}
		}
		return true;
	}
	

	@Test
	void test_add_firstIndices() {
		
		//Adding element in + first index
		ArrayList<Character> createPyList = new ArrayList<>(Arrays.asList('b','c','d','e'));
		PythonList<Character> positiveFirstPyList = new PythonList<Character>(createPyList);
		
		positiveFirstPyList.add(0, 'a');
		
		ArrayList<Character> charArrayOne = new ArrayList<>(Arrays.asList('a','b','c','d','e'));
		
		boolean AddBool = equalCheck(positiveFirstPyList, charArrayOne);		
		assertTrue(AddBool);
		
		//Adding element in - first index
		PythonList<Character> negativeFirstPyList = new PythonList<Character>(createPyList);
		
		negativeFirstPyList.add(-4, 'a');
		
		boolean secondAddBool = equalCheck(negativeFirstPyList, charArrayOne);
		assertTrue(secondAddBool);
		

	}
	
	@Test
	void test_add_lastIndices() {
		ArrayList<Character> createPyList = new ArrayList<>(Arrays.asList('b','c','d','e'));
		
		//Adding element in + last index
		PythonList<Character> positiveLastPyList = new PythonList<Character>(createPyList);
				
		positiveLastPyList.add(positiveLastPyList.size()-1, 'f');
				
		ArrayList<Character> charArray = new ArrayList<>(Arrays.asList('b','c','d','f','e'));
				
		boolean postiveAddBool = equalCheck(positiveLastPyList, charArray);		
		assertTrue(postiveAddBool);
				
		//Adding element in - last index
		PythonList<Character> negativeLastPyList = new PythonList<Character>(createPyList);
				
		negativeLastPyList.add(-1, 'f');
				
		boolean negativeAddBool = equalCheck(negativeLastPyList, charArray);		
		assertTrue(negativeAddBool);
	}
	
	@Test
	void test_add_illegalIndices() {
		//Tests out of bounds add attempts
		
		ArrayList<Character> createPyList = new ArrayList<>(Arrays.asList('a','b','c','d','e')); //Used to create filled python list
		PythonList<Character> errPyList = new PythonList<Character>(createPyList);
		
		//Tests error throwing with greater than greatest index
		assertThrows(IndexOutOfBoundsException.class, () -> { errPyList.add(errPyList.size(), 'z'); }); 
		
		//Tests error throwing with lesser than first index
		assertThrows(IndexOutOfBoundsException.class, () -> { errPyList.add(-6, 'z'); }); //Lesser than first index
		
	}
	
	@Test
	void test_get_firstIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5)); //Used to create filled python list
		PythonList<Integer> PyList = new PythonList<Integer>(createPyList);
		
		//Test getting first index with standard index
		int posFirstInd = PyList.get(0);
		assertEquals(1, posFirstInd);
		
		//Test getting first index with python index
		int negFirstInd = PyList.get(-5);
		assertEquals(1, negFirstInd);
	}
	
	@Test
	void test_get_lastIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5)); //Used to create filled python list
		PythonList<Integer> PyList = new PythonList<Integer>(createPyList);
		
		//Test getting last index with standard index
		int posLastInd = PyList.get(PyList.size()-1);
		assertEquals(5, posLastInd);
		
		//Test getting last index with python index
		int negLastInd = PyList.get(-1);
		assertEquals(5, negLastInd);
	}
	
	@Test
	void test_get_illegalIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5)); //Used to create filled python list
		PythonList<Integer> PyList = new PythonList<Integer>(createPyList);
		
		//Tests error throwing with greater than greatest index
		assertThrows(IndexOutOfBoundsException.class, () -> { PyList.get(PyList.size()); });
		
		//Tests error throwing with lesser than first index
		assertThrows(IndexOutOfBoundsException.class, () -> { PyList.get(-6); });
	}
	
	@Test
	void test_remove_firstIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5)); //Used to create filled python list
		
		//pyLists should look like this after removal
		ArrayList<Integer> removedFirstIndex = new ArrayList<>(Arrays.asList(2,3,4,5)); 
		
		PythonList<Integer> positiveRemovePyList = new PythonList<Integer>(createPyList);
		positiveRemovePyList.remove(0);
		
		//Tests removing first index using standard java index
		boolean positiveRemoveCheck = equalCheck(positiveRemovePyList, removedFirstIndex);
		assertTrue(positiveRemoveCheck);
		
		PythonList<Integer> negativeRemovePyList = new PythonList<Integer>(createPyList);
		negativeRemovePyList.remove(-5);
		
		//Tests removing first index using python index
		boolean negativeRemoveCheck = equalCheck(negativeRemovePyList, removedFirstIndex);
		assertTrue(negativeRemoveCheck);
	}
	
	@Test
	void test_remove_lastIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		
		ArrayList<Integer> removedLastIndex = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		PythonList<Integer> positiveRemovePyList = new PythonList<Integer>(createPyList);
		positiveRemovePyList.remove(positiveRemovePyList.size()-1);
		
		//Tests removing last index using standard java index
		boolean positiveRemoveCheck = equalCheck(positiveRemovePyList, removedLastIndex);
		assertTrue(positiveRemoveCheck);
		
		
		PythonList<Integer> negativeRemovePyList = new PythonList<Integer>(createPyList);
		negativeRemovePyList.remove(-1);
		
		//Tests removing last index using python index
		boolean negativeRemoveCheck = equalCheck(negativeRemovePyList, removedLastIndex);
		assertTrue(negativeRemoveCheck);
	}
	
	@Test
	void test_remove_emptyAndErrors() {
		ArrayList<Double> createPyList = new ArrayList<>(Arrays.asList(1.0));
		PythonList<Double> PyList = new PythonList<Double>(createPyList);
		
		ArrayList<Double> EmptyList = new ArrayList<>();
		
		PyList.remove(0);
		
		//Removing element from one element list should yield an empty list.
		boolean emptyCheck = equalCheck(PyList, EmptyList);
		assertTrue(emptyCheck);
		
		//Tests trying to remove item out of the right bounds 
		assertThrows(IndexOutOfBoundsException.class, () -> { PyList.remove(PyList.size()); });
		
		//Tests trying to remove item out of the left bounds 
		assertThrows(IndexOutOfBoundsException.class, () -> { PyList.remove(-2); });
	}
	
	@Test
	void test_set_firstIndices() {
		ArrayList<Double> createPyList = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
		
		ArrayList<Double> setFirstIndex = new ArrayList<>(Arrays.asList(7.0,2.0,3.0));
		
		PythonList<Double> positiveSetPyList = new PythonList<Double>(createPyList);
		positiveSetPyList.set(0, 7.0);
		
		//Tests setting first index of python list using standard index
		boolean positiveRemoveCheck = equalCheck(positiveSetPyList, setFirstIndex);
		assertTrue(positiveRemoveCheck);
		
		
		PythonList<Double> negativeSetPyList = new PythonList<Double>(createPyList);
		negativeSetPyList.set(-3, 7.0);
		
		//Tests setting first index of python list using python index
		boolean negativeRemoveCheck = equalCheck(negativeSetPyList, setFirstIndex);
		assertTrue(negativeRemoveCheck);
		
		
	}
	
	@Test
	void test_set_lastIndices() {
		ArrayList<Double> createPyList = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
		
		ArrayList<Double> setLastIndex = new ArrayList<>(Arrays.asList(1.0,2.0,9.0));
		
		PythonList<Double> positiveSetPyList = new PythonList<Double>(createPyList);
		positiveSetPyList.set(positiveSetPyList.size()-1, 9.0);
		
		
		//Tests setting last index of python list using standard index
		boolean positiveRemoveCheck = equalCheck(positiveSetPyList, setLastIndex);
		assertTrue(positiveRemoveCheck);
		
		
		PythonList<Double> negativeSetPyList = new PythonList<Double>(createPyList);
		negativeSetPyList.set(-1, 9.0);
		
		//Tests setting last index of python list using python index
		boolean negativeRemoveCheck = equalCheck(negativeSetPyList, setLastIndex);
		assertTrue(negativeRemoveCheck);
		
	}
	
	@Test
	void test_set_emptyAndErrors() {
		PythonList<Double> emptyPyList = new PythonList<Double>();
		
		//Tests out of bounds error when attempting to set on a empty python list
		assertThrows(IndexOutOfBoundsException.class, () -> { emptyPyList.set(0, 1.0); });
		
		ArrayList<Double> createPyList = new ArrayList<>(Arrays.asList(1.0,2.0,3.0));
		PythonList<Double> PyList = new PythonList<Double>(createPyList);
		
		//Tests catching out of bounds errors using standard and python indices
		assertThrows(IndexOutOfBoundsException.class, () -> { emptyPyList.set(emptyPyList.size(), 1.0); });
		assertThrows(IndexOutOfBoundsException.class, () -> { PyList.set(-4, 1.0); });
		
	}
	
	
	@Test
	void test_subList_firstIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		
		ArrayList<Integer> subListFirstIndex = new ArrayList<>(Arrays.asList(1,2,3));
		
		PythonList<Integer> positiveSetPyList = new PythonList<Integer>(createPyList);
		positiveSetPyList = positiveSetPyList.subList(0, 3);
		
		//Tests creating a lower range sublist using standard java index
		boolean positiveSubListCheck = equalCheck(positiveSetPyList, subListFirstIndex);
		assertTrue(positiveSubListCheck);
		
		PythonList<Integer> negativeSetPyList = new PythonList<Integer>(createPyList);
		negativeSetPyList = negativeSetPyList.subList(-5, -2);
		
		//Tests creating a lower range sublist using python index
		boolean negativeSubListCheck = equalCheck(negativeSetPyList, subListFirstIndex);
		assertTrue(negativeSubListCheck);
		
	}	
	@Test
	void test_subList_lastIndices() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		
		ArrayList<Integer> subListLastIndex = new ArrayList<>(Arrays.asList(3,4));
		
		PythonList<Integer> positiveSetPyList = new PythonList<Integer>(createPyList);
		positiveSetPyList = positiveSetPyList.subList(2, 4);
		
		//Tests creating an upper range sublist using standard index
		boolean positiveSubListCheck = equalCheck(positiveSetPyList, subListLastIndex);
		assertTrue(positiveSubListCheck);
		
		PythonList<Integer> negativeSetPyList = new PythonList<Integer>(createPyList);
		negativeSetPyList = negativeSetPyList.subList(-3, -1);
		
		//Tests creating an upper range sublist using python index
		boolean negativeSubListCheck = equalCheck(negativeSetPyList, subListLastIndex);
		assertTrue(negativeSubListCheck);
	}
	
	@Test
	void test_subList_emptyAndFull() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> fullArr = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		ArrayList<Integer> emptyArr = new ArrayList<>(Arrays.asList());
		
		PythonList<Integer> subListEmpty = new PythonList<Integer>(createPyList);
		subListEmpty = subListEmpty.subList(0, 0);
		
		//Tests if getting a sublist using identical indices yields an empty collection
		boolean emptySubListCheck = equalCheck(subListEmpty, emptyArr);
		assertTrue(emptySubListCheck);
		
		
		PythonList<Integer> subListFull = new PythonList<Integer>(createPyList);
		subListFull = subListFull.subList(0, subListFull.size()-1);
		
		//Tests if using entire range of indices yields the full original collection
		boolean fullSubListCheck = equalCheck(subListFull, fullArr);
		assertTrue(fullSubListCheck);
	}
	
	@Test
	void test_subList_Errors() {
		ArrayList<Integer> createPyList = new ArrayList<>(Arrays.asList(1,2,3,4,5));		
		PythonList<Integer> pySubList = new PythonList<Integer>(createPyList);
		
		//Tests error throwing when indices provided for sublist are incompatible
		// When minimum is greater than maximum, using standard and python indices
		assertThrows(IllegalArgumentException.class, () -> { pySubList.subList(2, 1); });
		assertThrows(IllegalArgumentException.class, () -> { pySubList.subList(-1, -2); });
	}
	

}
