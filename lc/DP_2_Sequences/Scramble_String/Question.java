package Scramble_String;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s1 = "great";
		String s2 = "rgtae";
		System.out.println(q.isScramble(s1, s2));
	}
	
	/**
	 * https://oj.leetcode.com/problems/scramble-string/
	 * Given a string s1, we may represent it as a binary tree by partitioning it 
	 * to two non-empty substrings recursively.
		Below is one possible representation of s1 = "great":
		
		    great
		   /    \
		  gr    eat
		 / \    /  \
		g   r  e   at
		           / \
		          a   t
		To scramble the string, we may choose any non-leaf node and swap its two children.
		For example, if we choose the node "gr" and swap its two children, 
		it produces a scrambled string "rgeat".
		
		    rgeat
		   /    \
		  rg    eat
		 / \    /  \
		r   g  e   at
		           / \
		          a   t
		We say that "rgeat" is a scrambled string of "great".
		Similarly, if we continue to swap the children of nodes "eat" and "at", 
		it produces a scrambled string "rgtae".
		
		    rgtae
		   /    \
		  rg    tae
		 / \    /  \
		r   g  ta  e
		       / \
		      t   a
		We say that "rgtae" is a scrambled string of "great".
		Given two strings s1 and s2 of the same length, determine 
		if s2 is a scrambled string of s1.
	 */
	
	//DP 2_Seq
	//state: res[i][j][len]，其中i是s1的起始字符，j是s2的起始字符，而len是当前的字符串长度，res[i][j][len]表示的是以i和j分别为s1和s2起点的长度为len的字符串是不是互为scramble。
	//function: res[i][j][len] = || (res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k]) 对于所有1<=k<len，也就是对于所有len-1种劈法的结果求或运算
	//initialize: result[i][j][1] = s1.charAt(i) == s2.charAt(j);
	//result: result[0][0][strLen]
	
	//http://blog.csdn.net/linhuanmars/article/details/24506703
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
        	return false;
        }
        if (s1.length() == 0) {
        	return true;
        }
        int strLen = s1.length();
        boolean[][][] result = new boolean[strLen][strLen][strLen + 1]; //第三维（选取长度）==0时无意义
        //初始化s1, s2长度为1的情况
        for (int i = 0; i < strLen; i++) {
        	for (int j = 0; j < strLen; j++) {
        		result[i][j][1] = s1.charAt(i) == s2.charAt(j);
        	}
        }
        for (int len = 2; len <= strLen; len++) { // 即组成左边scramble+右边scramble可能的长度从2一直到strLEn
        	for (int i = 0; i < strLen + 1 - len; i++) { // 关于边界：i < len + 1 - k; 令k为初始值2，i本来要走到len-1，则带入对比系数课得之。
        		for (int j = 0; j < strLen + 1 - len; j++) {
        			for (int k = 1; k < len; k++) { //k可以把len劈len - 1刀，即k可以出现在len内部的（1~len - 1）位置上
        				//对于当前k，只要有一组i,j满足条件就可以把result[i][j][k]置为true，所以用“|=”来“或”每一步的结果来得到最终结果
        				//【注】要时刻分清k和len的区别：len是当前的字符串长度，k表示的是在len这么长的串里劈那1刀的位置（此处的表达式里不可能再出现strLen了）
        				result[i][j][len] |= result[i][j][k] && result[i + k][j + k][len - k] || result[i][j + len - k][k] && result[i + k][j][len - k];
        			}
        		}
	        }
        }
        return result[0][0][strLen];
    }
    
    //recursion: 是O(3^n)。
    //但剪枝可以降低复杂度，即"进入递归前，先把2个字符串排序，再比较，如果不相同，则直接退出掉。这样能有效地减少复杂度，具体多少算不清。但能通过leetcode的检查。"
  //在leetcode实际效果中，recursion比DP要快
    //http://www.cnblogs.com/yuzhangcmu/p/4189152.html
    public boolean isScrambleRecursion(String s1, String s2) {
    	if (s1 == null || s2 == null || s1.length() != s2.length()) {
        	return false;
        }
        if (s1.length() == 0) {
        	return true;
        }
        return helper(s1, s2);
    }
    
    private boolean helper(String s1, String s2) {
    	int len = s1.length();
    	if (len == 1) { //base case结束条件
    		return s1.equals(s2);
    	}
    	//剪枝，如果s1和s2排序好之后不相同，则他们肯定不可能是scramble的
    	char[] s1Char = s1.toCharArray();
    	Arrays.sort(s1Char);
    	String s1Sort = new String(s1Char); // 【注】s1Char.toString();这样写是错的！s1Sort的实际内容是hashcode而不是s1Char的内容！
    	char[] s2Char = s2.toCharArray();
    	Arrays.sort(s2Char);
    	String s2Sort = new String(s2Char);
    	if (!s1Sort.equals(s2Sort)) {
    		return false;
    	}
    	//划分两个字符串
    	for (int i = 1; i < len; i++) { // 只要在len长度中有任何一种划分位置i，可以满足scramble，则true
    		//scramble两种情况：满足其中一种则true
    		//left - left && right - right 
    		if (helper(s1.substring(0, i), s2.substring(0, i)) && helper(s1.substring(i, len), s2.substring(i, len))) {
    			return true;
    		}
    		//left - right && right - left 【注】留意right的起始位置
    		if (helper(s1.substring(0, i), s2.substring(len - i, len)) && helper(s1.substring(i, len), s2.substring(0, len - i))) {
    			return true;
    		}
    	}
    	//如果上面的所有len的所有i的划分都没成功，则false
    	return false;
    }

}
