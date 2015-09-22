package Valid_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "001";
		System.out.println(q.isNumber(s));

	}
	
	/**
	 * https://oj.leetcode.com/problems/valid-number/
	 * Validate if a given string is numeric.
	 * 
	 * Some examples: 
	 * "0" => true 
	 * " 0.1 " => true 
	 * "abc" => false 
	 * "1 a" => false
	 * "2e10" => true 
	 * 
	 * Note: It is intended for the problem statement to be
	 * ambiguous. You should gather all requirements up front before
	 * implementing one.
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4060348.html  此题trick很多。
	//对每个字符串中的字符位，需要做两件事：
	//1.根据当前位的值，以及其左边出现过的值的联合起来是否非法。 
	//2.处理完本位后，更新因此产生的各个flag的变化。
	//合法原则（反面即为非法）：
	//(1). 当前为e，则前面要有digit,不能有e.
	//(2). 当前为.  则是一个小数，所以前面不可以有.和e
	//(3). 当前为+, - 那么它必须是第一个，或者前一个是e，比如" 005047e+6"
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		boolean dot = false; //表示当前位左边是否出现过'.'
		boolean exp = false; //表示当前位左边是否出现过e/E
		boolean num = false; //表示当前位左边是否出现过数字
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'e' || c == 'E') {
				if (!num || exp) {
					return false;
				}
				exp = true;
				num = false; //【注】对于e出现之后的字符，number相当于从未出现过，所以重置为false。
			} else if (c == '.') {
				if (exp || dot) {
					return false;
				}
				dot = true;
			} else if (c == '+' || c == '-') {
				if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) { // 即c既不在首位，它的前一个也不是e/E，则返回false
					return false;
				}
			} else if (c >= '0' && c <= '9') {
				num = true;
			} else {
				return false; // invalid char
			}
		}
		return num; //【注】此处返回num，以防输入只有一个符号（+ - .）。
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/23809661
    /*public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		boolean dotFlag = false; // 是否此前已经出现过了'.'
		boolean eFlag = false; // 是否此前已经出现过了'e/E'
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '.':
				// 1.（1）前面不能有小数点或者‘e’和‘E’；（2）前一位是数字（除非它已经是第一位了）或者后一位要是数字（除非它已经是最后一位了）。
				// 如果和上面条件相违背，则false
				if (dotFlag || eFlag || ((i == 0 || !(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) 
						&& (i == s.length() - 1 || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')))) {
					return false;
				}
				dotFlag = true;
				break;
			case '+':
			case '-':
				// 2.（1）必须是第一位或者在‘e’和‘E’后一位；（2）后一位要是数字。(3) 它的下一位不能是'.'
				// 如果和上面条件相违背，则false
				if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') || (i == s.length() - 1 || 
						!(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9' || s.charAt(i + 1) == '.'))) {
					return false;
				}
				break;
			case 'e':
			case 'E':
				// 3.（1）前面不能有‘e’和‘E’出现过；（2）不能是第一位（前面没数字科学计数没有意义）或者最后一位（后面没数字就不用写指数了）。
				// 如果和上面条件相违背，则false
				if (eFlag || i == 0 || i == s.length() - 1) {
					return false;
				}
				eFlag = true;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				break;
			default:
				return false;
			}
		}
		return true;
    }*/

}
