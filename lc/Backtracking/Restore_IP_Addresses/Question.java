package Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "25525511135";
		List<String> result = q.restoreIpAddresses(s);
		for (String item : result) {
			System.out.println(item);
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/restore-ip-addresses/
	 * Given a string containing only digits, restore it by returning all
	 * possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	//画搜索树（“层数不会超过四层”）
	//http://www.ninechapter.com/solutions/restore-ip-addresses/
	//http://blog.csdn.net/linhuanmars/article/details/24683699
    public List<String> restoreIpAddresses(String s) {
    	List<String> result = new ArrayList<String>(); // 结果集
        if (s == null || s.length() < 4 || s.length() > 12) {
        	return result;
        }
        //一个合法结果用size为4的ArrayList<String>表示，其中的每个string表示一个2^8以内的数字
        //（将其转化为一个真正合法的解，会在“item.size() == 4”里进行）
        ArrayList<String> item = new ArrayList<String>(); 
        int start = 0; //start表示当前正在处理以start位起始的，值在2^8以内的字符串
        helper(result, item, s, start);
        return result;
    }
    
    private void helper(List<String> result, List<String> item, String s, int start){
    	if (item.size() == 4 && start == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String str : item) {
				sb.append(str).append(".");
			}
			sb.deleteCharAt(sb.length() - 1); // 删去末尾的'.'
			result.add(sb.toString());
			return;
		}
		//i必须在s.length()以内；并且i 范围[start, start + 3)，因为一个合法的2^8以内的字符串长度<=3
		for (int i = start; i < s.length() && i < start + 3; i++) { 
			String temp = s.substring(start, i + 1); // 取start到当前i之间的substring为temp
			if (isValid(temp)) {
				item.add(temp); // item中加入temp
				helper(result, item, s, i + 1); // start置为i + 1位，继续递归
				item.remove(item.size() - 1); // 回溯
			}
		}
	}

    //检查给定的str是否符合一个2^8以内的合法字符串表示
	private boolean isValid(String str) {
		//str为空 或者长度不对时,则false
		if (str == null || str.length() == 0 || str.length() > 3) {
			return false;
		}
		//str如果以'0'开头，并且str不为"0"时（比如str为"00"，"01","002" etc），则false
		if (str.charAt(0) == '0' && str.length() > 1) {
			return false;
		}
		int num = Integer.parseInt(str); // str转为数值，看其范围是否在[0, 255]之内
		return (num >= 0 && num <= 255);
	}
}
