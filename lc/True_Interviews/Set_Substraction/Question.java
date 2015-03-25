package Set_Substraction;

import java.util.ArrayList;
import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A =  {1,2,3,4,5,6,11,11,22,22,34};
		int[] B =  {3,3,4};
		Question q = new Question();
		ArrayList<Integer> res = q.substract(A, B);
		for (int num : res) {
			System.out.print(num + ",");
		}

	}

	/**
	 * http://www.glassdoor.com/Interview/Implement-a-function-that-takes-the-set-wise-subtraction-of-two-sorted-sets-of-integers-ie-A-1-2-3-B-3-4-5-and-QTN_877613.htm
	 * mplement a function that takes the set-wise subtraction of   two sorted sets of integers. 
	 * ie A = {1, 2, 3}, B = {3, 4, 5} => A - B = {1, 2}. 
	 * There can be duplicates, in which case all duplicates should be removed should there be an occurrence in B. 
	 * IE: {1, 2, 3, 3, 3} - {2, 3} = {1}
	 */
	
	//O(1) space
	public ArrayList<Integer> substract(int[] A, int[] B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A == null || A.length == 0) {
			return res;
		}
		if (B == null || B.length == 0) {
			for (int num : A) {
				res.add(num);
			}
			return res;
		}
		int aim = B[0];
		int l = 0;
		int r = A.length - 1;
		// find the first element in A that is equals to aim, 
		//if there is no such element, find the first element that is bigger that 10, 
		//if still cannot find, then there is nothing to substract from A
		while (l + 1 < r) { 
			int m = l + (r - l) / 2;
			if (A[m] >= aim) {
				r = m;
			} else {
				l = m;
			}
		}
		int idx = 0;
		if (A[l] == aim) {
			idx = l;
		} else if (A[r] == aim) {
			idx = r;
		} else if (aim < A[l]) {
			idx = l;
		} else if (A[l] < aim && aim < A[r]) {
			idx = r;
		} else {
			idx = A.length;
		}
		for (int i = 0; i <= idx; i++) {
			if (A[i] != aim) {
				res.add(A[i]);
			}
		}
		idx++;
		for (int i = 1; i < B.length && idx < A.length; i++) {
			if (B[i] == B[i - 1]) {
				continue;
			}
			while (idx < A.length) {
				if (A[idx] < B[i]) {
					res.add(A[idx]);
					idx++;
				} else if (A[idx] == B[i]){
					idx++;
				} else {
					break;
				} 
			}
		}
		for (int i = idx; i < A.length; i++) {
			res.add(A[i]);
		}
		return res;
	}
	
	
	//use HashMap
	public ArrayList<Integer> substractHashMap(int[] A, int[] B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A == null || A.length == 0) {
			return res;
		}
		if (B == null || B.length == 0) {
			for (int num : A) {
				res.add(num);
			}
			return res;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : B) {
			set.add(num);
		}
		for (int num : A) {
			if (!set.contains(num)) {
				res.add(num);
			}
		}
		return res;
	}
}
