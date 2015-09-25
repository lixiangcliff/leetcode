package Nested_Collection_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l0 = new ArrayList<Integer>();
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(4));
		ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(5, 6));
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		ArrayList<Integer> l5 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		lists.add(l0);
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);
		lists.add(l5);
		NestedIterator ni = new NestedIterator(lists);
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext());
		System.out.println(ni.next());
		
		System.out.println(ni.hasNext()); //extra
		System.out.println(ni.next());
	}
	
	//similar to http://stackoverflow.com/questions/19163889/how-to-implement-iterator-on-nested-collection-in-java

}

class NestedIterator{
	private ArrayList<ArrayList<Integer>> lists;
	private int out;
	private Iterator<Integer> in;
	
	public NestedIterator( ArrayList<ArrayList<Integer>> lists){
		this.lists = lists;
		this.out = 0;
		this.in = lists.get(0).iterator();
	}
	
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (in.hasNext()) { // 在当前的arraylist就找到下一个slot了
			return true;
		}
		int cur = out + 1;
		while (cur < lists.size()) { //持续检查剩下的所有arraylist
			Iterator<Integer> curIn = lists.get(cur).iterator();
			if (curIn.hasNext()) {
				return true;
			} else {
				cur++;
			}
		}
		return false;
	}

	public Integer next() {
		// TODO Auto-generated method stub
		if (in.hasNext()) {
			return in.next();
		} else {
			out++;
			while (out < lists.size()) { //持续检查剩下的所有arraylist
				in = lists.get(out).iterator();
				if (in.hasNext()) {
					return in.next();
				} else {
					out++;
				}
			}
		}
		return null;
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
