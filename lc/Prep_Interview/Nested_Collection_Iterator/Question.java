package Nested_Collection_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//similar to http://stackoverflow.com/questions/19163889/how-to-implement-iterator-on-nested-collection-in-java

}

class NestedIterator<Integer> implements Iterator<Integer> {
	private ArrayList<ArrayList<Integer>> list;
	Iterator<Iterator<Integer>> out = null;
	Iterator<Integer> in =null;
	public NestedIterator( ArrayList<ArrayList<Integer>> alist){
		list = alist;
		//out = list.iterator();
		
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
