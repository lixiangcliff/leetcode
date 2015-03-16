package Implement_strStr;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.strStr("h", "h"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/implement-strstr/
	 * Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * Update (2014-11-02): The signature of the function had been updated to
	 * return the index instead of the pointer. If you still see your function
	 * signature returns a char * or String, please click the reload button to
	 * reset your code definition.
	 */
	
	//两个指针，一个i在haystack从左往右，另一个j在needle从左往右
	//i单方向移动；j遇到needle.charAt(j) != haystack.charAt(i + j)就从头再来
	//brutal force
	//http://blog.csdn.net/linhuanmars/article/details/20276833
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}
		int hLen = haystack.length();
		int nLen = needle.length();
		if (hLen < nLen) {
			return -1;
		}
		for (int i = 0; i <= hLen - nLen; i++) { // 【注】i <= hLen - nLen; 边界最好办法就是举例子
			int j;
			for (j = 0; j < nLen; j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
			if (j == nLen) { // j已经走完了整个needle
				return i;
			}
		}
		return -1;
	}
}
