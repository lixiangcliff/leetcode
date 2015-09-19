package Strobogrammatic_Number_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		List<String> item = q.findStrobogrammatic(4);
		for (String i : item) {
			System.out.println(i);
		}
	}
	
	/**
	 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
	 * Find all strobogrammatic numbers that are of length = n.
	 */
	
	//还没看懂。。。需要再研究。。。
	//http://likesky3.iteye.com/blog/2237261
	//https://leetcode.com/discuss/50412/ac-clean-java-solution
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

	private List<String> helper(int left, int len) {
		if (left == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}
		if (left == 1) {
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		}
		List<String> list = helper(left - 2, len);
		List<String> res = new ArrayList<String>();
		for (String s : list) {
			if (left != len) {
				res.add("0" + s + "0");
			}
			res.add("1" + s + "1");
			res.add("8" + s + "8");
			res.add("6" + s + "9");
			res.add("9" + s + "6");
		}
		return res;
	}
	    

}
