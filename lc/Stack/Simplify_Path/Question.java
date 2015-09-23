package Simplify_Path;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question(); 
		System.out.println(q.simplifyPath("/a/./b/../../c/"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/simplify-path/
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * 
	 * For example, 
	 * path = "/home/", => "/home" 
	 * path = "/a/./b/../../c/", =>"/c" 
	 * 
	 * Corner Cases: 
	 * Did you consider the case where path = "/../"? In this
	 * case, you should return "/". 
	 * Another corner case is the path might contain multiple 
	 * slashes '/' together, such as "/home//foo/". In this
	 * case, you should ignore redundant slashes and return "/home/foo".
	 */
	
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		LinkedList<String> s = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		String[] strs = path.split("/"); // no need to excape
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(".") || strs[i].equals("")) { //【注】split出来的str有可能有""
				continue;
			} else if (strs[i].equals("..")) {
				if (!s.isEmpty()) { // 但凡出栈都要检查是否为空
					s.pop();
				}
			} else {
				s.push(strs[i]);
				System.out.println(strs[i]);
			}
		}
		if (s.isEmpty()) {
			return "/";
		}
		while (!s.isEmpty()) { 
			sb.insert(0, s.pop()); //stack里弹出来的是逆序的，所以要insert
			sb.insert(0, "/");
		}
		return sb.toString();
	}
	
	
	//手写
	public String simplifyPath2(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		LinkedList<StringBuilder> stack = new LinkedList<StringBuilder>();
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= path.length(); i++) { // 把path简化后的每一层的内容，放入stack中
			if (i == path.length() || path.charAt(i) == '/'){
				if (sb.length() > 0) { 
					if (sb.toString().equals("..")) {// 【注】比较两个string要用equals 
						if (!stack.isEmpty()) { //向上一层，即弹出一个元素
							stack.pop();
						}
					} else if (!sb.toString().equals(".")) {// 遇到"."，则什么也不做。否则就把sb压入栈
						stack.push(sb);
					} 
					sb = new StringBuilder();
				}
			} else {
				sb.append(path.charAt(i));
			}
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				result.append(stack.pop().reverse());
				result.append("/");
			}
			return result.reverse().toString();
		} else {
			return "/"; // stack为空时的情况
		}
	}
	
	// http://blog.csdn.net/linhuanmars/article/details/23972563
	public String simplifyPath3(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		LinkedList<StringBuilder> stack = new LinkedList<StringBuilder>();
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < path.length()) { // 把path简化后的每一层的内容，放入stack中
			int idx = i;
			StringBuilder temp = new StringBuilder();
			while (i < path.length() && path.charAt(i) != '/') {// temp来表示"/"与"/"之间的内容
				temp.append(path.charAt(i++));
			}
			if (i != idx) { // idx相比于i向右移动了，说明确实有内容加入temp里了
				if (temp.toString().equals("..")) {// 【注】比较两个string要用equals 。equals(): 检查内容是否相同 ；== ：检查是否是对同一个object的引用
					if (!stack.isEmpty()) { //向上一层，即弹出一个元素
						stack.pop();
					}
				} else if (!temp.toString().equals(".")) {// 遇到"."，则什么也不做。否则就把temp压入栈
					stack.push(temp);
				} 
			}
			i++;
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				result.append(stack.pop().reverse());
				result.append("/");
			}
			return result.reverse().toString();
		} else {
			return "/"; // stack为空时的情况
		}
	}

}
