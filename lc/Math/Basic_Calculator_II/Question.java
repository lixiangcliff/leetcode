package Basic_Calculator_II;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "3+2*2";
		System.out.println(q.calculate(s));

	}
	
	/**
	 * https://leetcode.com/problems/basic-calculator-ii/
	 * Implement a basic calculator to evaluate a simple expression string.
	 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
	 * The integer division should truncate toward zero.
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples:
	 * "3+2*2" = 7
	 * " 3/2 " = 1
	 * " 3+5 / 2 " = 5
	 * 
	 * Note: Do not use the eval built-in library function.
	 */
	
	//https://leetcode.com/discuss/41627/easy-c-solution-with-detailed-explanations
	//O(1) space
	public int calculate(String s) {
		int sign = 1;
		int res = 0;
		int[] idx = {0}; //用一个数组，这样调用getNum()之后，idx[0]的值也会随之改变。
		int num = getNum(s, idx); // 先拿到第一个操作数。累积到当前的计算结果
		while (idx[0] < s.length()) {
			char c = s.charAt(idx[0]);
			idx[0]++;
			if (c == '+' || c == '-') { //遇到加减法，把前面的累积算上，然后把后面的符号置上
				res += num * sign;
				num = getNum(s, idx); //之前的已经结算完了，现在重置num
				sign = c == '+' ? 1 : -1; //重置sign
			} else if (c == '*') { // 遇到乘除法就“当场”计算，重新获得最新的num
				num *= getNum(s, idx);
			} else if (c == '/') {
				num /= getNum(s, idx);
			} else {
				idx[0]--;
			}
		}
		res += num * sign; //计算最后一笔
		return res;
	}
	
	private int getNum(String s, int[] idx) {
		int num = 0;
		while (idx[0] < s.length()) {
			if (Character.isDigit(s.charAt(idx[0]))) {
				num = num * 10 + s.charAt(idx[0]) - '0';
			} else if  (s.charAt(idx[0]) != ' ') {
				return num;
			}
			idx[0]++;
		}
		return num;
	}
	//https://leetcode.com/discuss/41627/easy-c-solution-with-detailed-explanations
	//两个deque的方法，超时
/*    public int calculate(String s) {
    	ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
    	ArrayDeque<Character> ops = new ArrayDeque<Character>();
    	int[] idx = {0};
    	for (; idx[0] < s.length(); idx[0]++) { //第一次遍历，计算所有乘除法
    		char cur = s.charAt(idx[0]);
			if (Character.isDigit(cur)) {
				int num = getNumber(s, idx);
				nums.push(num);
			} else if (cur == '/' || cur == '*') { //如果是乘除法，以stack的方式当场计算
				int num1 = nums.pop();
				idx[0]++; //取乘除法的第二个操作数
				while (!Character.isDigit(s.charAt(idx[0]))) { //去掉所有空格
					idx[0]++;
				}
				int num2 = getNumber(s, idx);
				if (cur == '*') {
					nums.push(num1 * num2);
				} else {
					nums.push(num1 / num2);
				}
			} else if (cur == '+' || cur == '-') { //第一次遍历时，遇到所有的加减法符号都压入栈ops
				ops.push(cur);
			}
    	}
    	while (!ops.isEmpty()) { //第二次遍历，计算所有加减法
    		int num1 = nums.removeLast();
    		int num2 = nums.removeLast();
    		System.out.println(num1);
    		System.out.println(num2);
    		char op = ops.removeLast();
    		if (op == '+') {
    			nums.addLast(num1 + num2);
    		} else {
    			nums.addLast(num1 - num2);
    		}
    	}
        return nums.pop();
    }
    
    private int getNumber(String s, int[] idx) {
    	int num = 0;
    	while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
    		num = num * 10 + s.charAt(idx[0]++) - '0';
    	}
    	idx[0]--;
    	return num;
    }*/
    


}
