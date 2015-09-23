package ZigZag_Conversion;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.convert("PAYPALISHIRING",3));
	}
	
	/**
	 * https://oj.leetcode.com/problems/zigzag-conversion/
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility)
	 * 
	 * P   A   H   N 
	 * A P L S I I G 
	 * Y   I   R 
	 * And then read line by line: "PAHNAPLSIIGYIR"
	 * 
	 * Write the code that will take a string and make this conversion given a
	 * number of rows:
	 * 
	 * string convert(string text, int nRows); 
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	
	
	//http://blog.csdn.net/linhuanmars/article/details/21145039
    public String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || nRows <= 0) {
			return "";
		}
		if (nRows == 1) {
			return s;
		}
		int size = 2 * nRows - 2; // 每一个"下"+"上"一共多少字符.举例：PAYP, ALIS, HIRI, etc
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++) { // 以行为单位来处理,i表示row
			for (int j = i; j < s.length(); j += size) { // 【注】 j在s中每次递进size个位置，j表示真正在s中的index
				sb.append(s.charAt(j));
				if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length()) {// 不在第一行，且不在最后一行，且当前j仍在s长度内
					sb.append(s.charAt(j + size - 2 * i)); // s.charAt(x) 求x的表示方式的最好办法就是，画图举例。(j和他右边一个的差值，随着i的增加而递减)
				}
			}
		}
		return sb.toString();
    }

}
