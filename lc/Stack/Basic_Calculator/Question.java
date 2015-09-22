package Basic_Calculator;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = " 2-1 + 2 ";
		//String s = "211111111";
		StringBuilder sb = new StringBuilder();
		sb.append('1');
		//System.out.println(new StringBuilder().length() == 0);
		//System.out.println(Integer.parseInt(sb.toString()));
		System.out.println(q.calculate(s));
		//System.out.println(Integer.MAX_VALUE);
		
		
	}
	
	/**
	 * https://leetcode.com/problems/basic-calculator/
	 * Implement a basic calculator to evaluate a simple expression string.
	 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
	 * You may assume that the given expression is always valid.
	 * "1 + 1" = 2
	 * " 2-1 + 2 " = 3
	 * "(1+(4+5+2)-3)+(6+8)" = 23
	 * Note: Do not use the eval built-in library function.
	 */

	//https://leetcode.com/discuss/39458/64-ms-c-easy-solution
    public int calculate(String s) {
    	LinkedList<Integer> s1 = new LinkedList<Integer>();
    	LinkedList<Character> s2 = new LinkedList<Character>();
    	StringBuilder sb = new StringBuilder();
    	for (int i = s.length() - 1; i >= 0; i--) { //【注】必须从右往左压栈！操作数和操作符弹出时候才能从左往右计算
    		char c = s.charAt(i);
    		if (c == ')' || c == '+' || c == '-') { //c 是操作符
    			s2.push(c);
    		} else if (c >= '0' && c <= '9') { // c 操作数的一部分
    			sb.insert(0, c);
    			if (i == 0 || s.charAt(i - 1) < '0' || s.charAt(i - 1) > '9') { //【注】当前操作数已经取完（已走到首位，或者左一位不为数字）
    				s1.push(Integer.parseInt(sb.toString()));
    				sb = new StringBuilder();
    			}
    		} else if (c == '(') { //【注】碰到'(', 出现了一对完整的括号，这时要把这对括号内的计算式都完成（即去括号的过程）
    			while (s2.peek() != ')') {
    				cal(s1, s2);
    			}
    			s2.pop(); // pop出s2里的')'
    		}
    		
    	}
    	while (!s2.isEmpty()) {
    		cal(s1, s2);
    	}
        return s1.pop(); 
    }
    
    //从s1栈顶拿出两个数，然后用s2栈顶符号计算之后，放回s1的栈顶。
    private void cal(LinkedList<Integer> s1, LinkedList<Character> s2) {
    	int num1 = s1.pop();
    	int num2 = s1.pop();
    	char oper = s2.pop();
    	int res = 0;
    	if (oper == '+') {
    		res = num1 + num2;
    	} else if (oper == '-'){
    		res = num1 - num2;
    	}
    	s1.push(res);
    }
    
}
