package String_to_Integer_atoi;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.atoi("       2134x    125"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/string-to-integer-atoi/
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 * 
	 * spoilers alert... click to show requirements for atoi.
	 * Requirements for atoi: The function first discards as many whitespace
	 * characters as necessary until the first non-whitespace character is
	 * found. Then, starting from this character, takes an optional initial plus
	 * or minus sign followed by as many numerical digits as possible, and
	 * interprets them as a numerical value.
	 * 
	 * The string can contain additional characters after those that form the
	 * integral number, which are ignored and have no effect on the behavior of
	 * this function.
	 * 
	 * If the first sequence of non-whitespace characters in str is not a valid
	 * integral number, or if no such sequence exists because either str is
	 * empty or it contains only whitespace characters, no conversion is
	 * performed.
	 * 
	 * If no valid conversion could be performed, a zero value is returned. If
	 * the correct value is out of the range of representable values, INT_MAX
	 * (2147483647) or INT_MIN (-2147483648) is returned.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/21145129
    public int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim(); //去除首尾的space
		if (str.length() == 0) { // trim之后需再次判断str长度
			return 0;
		}
		boolean isPositive = true;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') { // 判断符号
			if (str.charAt(0) == '-') {
				isPositive = false;
			}
			str = str.substring(1);
		}
		int result = 0; // 此后result统一当做正数来处理，最后恢复符号。
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') { // 遇到非法字符就停止
				break;
			}
			int digit = (int) (str.charAt(i) - '0');
			//即先判断这一轮计算出的result是否越界(即恢复符号的result为负数，并且-(result * 10 + digit) < Integer.MIN_VALUE;但是必须用除法判断)若越界则返回最小值
			if (!isPositive && result > -((Integer.MIN_VALUE + digit) / 10)) {
				return Integer.MIN_VALUE;
			} else if (isPositive && result > (Integer.MAX_VALUE - digit) / 10) { //(恢复符号的result为正数，且(result * 10 + digit) > Integer.MAX_VALUE;用除法)	
				return Integer.MAX_VALUE;
			}
			result = result * 10 + digit;
		}
		return isPositive ? result : -result;
    }

}
