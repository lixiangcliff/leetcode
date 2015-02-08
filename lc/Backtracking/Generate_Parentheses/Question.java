package Generate_Parentheses;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<String> result = q.generateParenthesis(3);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/generate-parentheses/
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 */
	
	//手写时候想到的
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> result =  new ArrayList<String>();
    	StringBuilder item = new StringBuilder();
    	helper(result, item, n, n);
    	return result;
    }
    
    private void helper(ArrayList<String> result, StringBuilder item, int left, int right) { // left means how many "(" are still unused
    	if (left < 0 || right < 0|| left > right) { // 左或右括号剩余量为负；或者如果左括号剩下的比右括号剩下的多，即已经使用的右括号比左括号多，则非法，则返回。
    		return;
    	}
    	if (left == 0 && right == 0) { // 所有左右括号都使用完了，返回一个完整的合法解
    		result.add(new String(item.toString()));
    	}
		item.append("(");
		helper(result, item, left - 1, right);
		item.deleteCharAt(item.length() - 1);
		item.append(")");
		helper(result, item, left, right - 1);
		item.deleteCharAt(item.length() - 1);
    }
    
	//http://www.ninechapter.com/solutions/generate-parentheses/
	//http://blog.csdn.net/linhuanmars/article/details/19873463
/*    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> result =  new ArrayList<String>();
    	String item = "";
    	helper(result, item, n, n);
    	return result;
    }
    
    //DFS item为到目前为止已经组成的部分合法结；left和right分别为还剩多少未使用的左括号和右括号
    private void helper(ArrayList<String> result, String item, int left, int right) { // left means how many "(" are still unused
    	if (left < 0 || right < 0|| left > right) { // 左或右括号剩余量为负；或者如果左括号剩下的比右括号剩下的多，即已经使用的右括号比左括号多，则非法，则返回。
    		return;
    	}
    	if (left == 0 && right == 0) { // 所有左右括号都使用完了，返回一个完整的合法解
    		result.add(item);
    	}
		// 把一个左括号加入到item的尾部，然后递归处理
		helper(result, item + "(", left - 1, right);
		// 把一个右括号加入到item的尾部，然后递归处理t
		helper(result, item + ")", left, right - 1);
    }*/
	
}
