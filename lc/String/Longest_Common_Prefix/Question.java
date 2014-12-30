package Longest_Common_Prefix;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {
				"abcdefg",
				"abcdefg",
				"abcdefg",
				"abcdefgh",
				
		};
		Question q = new Question();
		String result = q.longestCommonPrefix(strs);
		System.out.print(result);

	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-common-prefix/
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/21145733
    public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		boolean stillSame = true;
		int index = 0;
		while (stillSame) {
			for (int i = 0; i < strs.length; i++) { //遍历数组中每一个string，来比较当前位
				//index已经超过任何一个string的长度了，或者存在某两个string在第index位不同了(都跟第0个相比)
				if (index >= strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) { 
					stillSame = false;
					break;
				}
			}
			if (stillSame) { //只有数组中所有string长度都够长，并且当前位上的char相同，index才加1
				index++;
			}
		}
		return strs[0].substring(0, index);
    }    

}
