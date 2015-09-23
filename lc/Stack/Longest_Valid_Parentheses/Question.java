package Longest_Valid_Parentheses;

import java.util.Arrays;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(longestValidParentheses("(()"));
		Question q = new Question();
		//System.out.println(q.longestValidParentheses("())"));
		
	        char[] chars = new char[] {'\u0097'};
	        String str = new String(chars);
	        byte[] bytes = str.getBytes();
	        System.out.println(str);
	        System.out.println(Arrays.toString(bytes));
	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-valid-parentheses/
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 */
	
	//易于理解 https://leetcode.com/discuss/7609/my-o-n-solution-using-a-stack
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>(); // <index>
		for (int i = 0; i < s.length(); i++) { 
			if (s.charAt(i) == '(') { // all "left" push into stack
				stack.push(i);
			} else { // then it is "right"
				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') { // find matched "left" on top of the stack；【错！】stack.peek()【错！】
					stack.pop();
				} else { // there is no match in the stack
					stack.push(i); // push this "right" in the stack(this is an un-matched one) 
				}
			}
		}
		if (stack.isEmpty()) { // mean all are matched
			return s.length();
		}
		int cur = s.length() - 1;
		int max = 0;
		while (cur >= 0) { // 计算stack里un-matched的index的间隔，来确定max
			int top = !stack.isEmpty() ? stack.pop() : -1; // 如果stack已经为空，则相当于stack的所谓栈顶元素top，取-1
			max = Math.max(max, cur - top); // max和cur的更新值边界，举例子
			cur = top - 1;
		}
		return max;
	}
	
	
	//http://www.cnblogs.com/yuzhangcmu/p/4113654.html
	//基本思想：遇到"("就入栈，遇到")"就出栈，栈中存的是index。统计合法长度的细节实现如下：
	//1. 使用栈来保存'('的index
	//2. 如果处理到的当前index为右括号，tmp表示以当前index为右括号，栈顶index为左括号的括号集的长度，
	//		此时tmp = i - stack.pop() + 1。
	//3. sum 表示数个连续完整的括号集的长度之和。
	//	例子：
	// 	每产生一套新的完整的括号集，如果紧邻前面有合法括号集，就可以把两套的长度加和起来【情况1】
	                    // () (()()) 这里“()”和“ (()())” 两个括号集长度可以加和
	//4. 不完整的括号集(即计算tmp时栈里仍有元素)：【情况2】
	//	这种情况也是需要计算的。也可能是一个未完成的括号集，比如：
	                    // (()()  在这里 ()() 是一个未完成的括号集，可以独立出来计算，作为阶段性的结果，但是就不能和前面的sum累计了
	//	【注】栈内仍有元素，则当前合法序列的长度为当前栈顶元素的位置下一位到当前元素的距离，因为栈顶元素后面的括号对肯定是合法的，而且左括号出过栈了。
	//		此时tmp = i - stack.peek(); 
	//		例如		0 1 2 3 4  -> 处理完0~3之后栈内元素为 0 3 ->此时处理4，弹出3，但是合法长度应为从1~4而不是从3~4
	//				( ( ) ( ) 						  ( (					即tmp = 4 -0 	
 	//5. 栈为空时，出现一个')'，就将sum置0.
    public int longestValidParentheses2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>(); //stack中存index
		int max = 0;
		int sum = 0;
		int tmp = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else { // 遇到")"
				if (stack.isEmpty()) {
					sum = 0;
				} else { // 栈里还有"("可以和当前")" 组成合法集
					tmp = i - stack.pop() + 1; //计算出由当前")"产生的合法集长度
					if (stack.isEmpty()) { //【情况1】【注】栈空了，说明从上一次累加sum之后剩余的所有"("都被弹出了，所以可以再次将temp累加到sum上了
						sum += tmp; // 把当前合法集长度加和到sum上
						max = Math.max(max, sum);
					} else { //【情况2】栈中还有剩余，说明从上次累计sum到现在还有剩余"("没有被弹出，所以上次的sum和这次的合法集之间不连续，所以这次的temp不可以累加到sum上
						tmp = i - stack.peek();
						max = Math.max(max, tmp);
					}
				}
			}
		}
		return max;
    }

}
