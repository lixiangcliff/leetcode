package Reverse_Words_in_a_String;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.reverseWords("      the      sky         is  blue     "));
	}
	
	/**
	 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
	 * Given an input string, reverse the string word by word.
	 * 
	 * For example, 
	 * Given s = "the sky is blue", 
	 * return "blue is sky the".
	 * 
	 * click to show clarification.
	 * Clarification: What constitutes a word? A sequence of non-space
	 * characters constitutes a word. Could the input string contain leading or
	 * trailing spaces? Yes. However, your reversed string should not contain
	 * leading or trailing spaces. How about multiple spaces between two words?
	 * Reduce them to a single space in the reversed string.
	 */
	
	//核心是用String[] array = s.split("\\s+")将原s分成若干string并存入数组, 然后逆序取出重组成反转的字符串
	//正则：\\s+
	// "\s"  : 匹配任何空白字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。
	// "+"   : 匹配前面的子表达式一次或多次。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。
	// "\\"  ： 转移字符，来表示 "\"
	//http://zh.wikipedia.org/wiki/%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F
	//http://www.cnblogs.com/yuzhangcmu/p/4140433.html
	//http://www.ninechapter.com/solutions/reverse-words-in-a-string/
    public String reverseWords(String s) {
    	if (s == null || s.length() == 0){
    		return "";
    	}
    	s = s.trim();
    	String[] strArray = s.split("\\s+");
    	StringBuilder sb = new StringBuilder();
    	for (int i = strArray.length - 1; i >= 0; i--) {
    		sb.append(strArray[i]).append(" ");
    	}
    	//如果sb不为空，则删去最后的空格
    	return sb.length() == 0 ? "" : sb.deleteCharAt(sb.length() - 1).toString() ;
    }

}
