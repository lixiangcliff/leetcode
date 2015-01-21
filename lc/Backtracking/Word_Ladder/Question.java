package Word_Ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.print(ladderLength(start, end, dict));
	}
	
	/**
	 * https://oj.leetcode.com/problems/word-ladder/
	 * Given two words (start and end), and a dictionary, find the length of
	 * shortest transformation sequence from start to end, such that:
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary 
	 * 
	 * For example,
	 * Given: 
	 * start = "hit" 
	 * end = "cog" 
	 * dict = ["hot","dot","dog","lot","log"]
	 * 
	 * As one shortest transformation is 
	 * "hit" -> "hot" -> "dot" -> "dog" ->"cog", 
	 * return its length 5.
	 * 
	 * Note: 
	 * Return 0 if there is no such transformation sequence. 
	 * All words  have the same length. 
	 * All words contain only lowercase alphabetic characters.
	 */
	//BFS
	//http://www.ninechapter.com/solutions/word-ladder/
	//http://shanjiaxin.blogspot.com/2014/04/word-ladder-leetcode.html
	//http://blog.csdn.net/linhuanmars/article/details/23029973
	public static int ladderLength(String start, String end, HashSet<String> dict) {  
	    if (start == null || end == null || start.length() != end.length() || start.length() == 0 || end.length() == 0) {
	    	return 0;
	    }
	    int len = 1;
	    LinkedList<String> queue = new LinkedList<String>();
	    queue.offer(start);
	    dict.remove(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curStr = queue.poll(); //拿到一个相差一个字符的String
				for (int j = 0; j < curStr.length();j++){
					//把curStr转为curChar[]必须在j loop内部，因为不同的char可能出现在curStr的不同位置（不同的j），
					//而我们又要通过改变了的curStr产生新的string，所以改变之后需要重新拿到原始的curChar才行
					char[] curCharArray = curStr.toCharArray(); 
					for (char c = 'a'; c <= 'z'; c++) { // 当前j位置上的char与其他的25个字母比较
						if (curStr.charAt(j) == c) {  //如果遇到c和当前j位置上char是一样的，则什么也不做
							continue;
						}
						curCharArray[j] = c; //走到这说明j位置上的char不为c，那么就把j位置上的char替换为c
						String temp = new String(curCharArray); //产生一个相比于原来curStr换了一个字符的新的string
						if (temp.equals(end)) { //如果新string已经等于end，则完成任务，返回当前len + 1
							return len + 1;
						}
						if (dict.contains(temp)) { //如果字典中确实含有这个新建的string
							queue.offer(temp);// 那么我们就把这个确实存在的并且和curStr正好相差一个字符的string放入队列，以备下一轮处理
							dict.remove(temp); //然后从字典中剔除这个相差一个字符的string，表示这个string已经visit过了
						}
		    		}
		    	}
	    	}
	    	len++; //当前queueSize里面的元素全都visit之后了，说明这一层已经访问结束。该进入下一层了。
	    }
	    return 0;
	}

	
}
