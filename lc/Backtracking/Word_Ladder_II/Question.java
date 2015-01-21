package Word_Ladder_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String start = "hit"; 
		String end = "cog"; 
		HashSet<String> dict = new HashSet<String>();
		String[] dictStrs = {"hot","dot","dog","lot","log"};
		for (String str : dictStrs) {
			dict.add(str);
		}
		ArrayList<ArrayList<String>> result = q.findLadders(start, end, dict);
		for (ArrayList<String> item : result) {
			for (String str : item) {
				System.out.print(str + ",");
			}
			System.out.println("");
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/word-ladder-ii/
	 * Given two words (start and end), and a dictionary, find all shortest
	 * transformation sequence(s) from start to end, such that:
	 * 
	 * 1. Only one letter can be changed at a time 
	 * 2. Each intermediate word must exist in the dictionary For example,
	 * 
	 * Given: 
	 * start = "hit" 
	 * end = "cog" 
	 * dict = ["hot","dot","dog","lot","log"]
	 * Return 
	 * [ 
	 * 	["hit","hot","dot","dog","cog"], 
	 * 	["hit","hot","lot","log","cog"]
	 * ] 
	 * Note: 
	 * All words have the same length. 
	 * All words contain only lowercase alphabetic characters.
	 */
	
	//				    lot - log
	//				  /  |	   |  \
	//		hit - hot    |	   |	cog
	//				  \  |	   |  /
	//				    dot - dog	
	//BFS + DFS
	//http://www.ninechapter.com/solutions/word-ladder-ii/
	//【注】在dfs中用breakpoint跟踪一下就全看明白了
	//http://blog.csdn.net/linhuanmars/article/details/23071455
	//"1）在替换String的某一位的字符时，先转换成char数组再操作；"
	//"2）如果按照正常的方法从start找end，然后根据这个来构造路径，代价会比较高，因为保存前驱结点容易，而保存后驱结点则比较困难。
	//	所以我们在广度优先搜索时反过来先从end找start，最后再根据生成的前驱结点映射从start往end构造路径，这样算法效率会有明显提高。"
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>(); // 结果集
    	ArrayList<String> item = new ArrayList<String>(); // 一个合法结果
    	// <单词, 该单词的所有邻居>： 单词为字典中存在的单词；邻居为和该单词只有一个字符不同的单词
    	HashMap<String, ArrayList<String>> neighborMap = new HashMap<String, ArrayList<String>>(); 
    	//<单词, 该单词到start的距离>
    	HashMap<String, Integer> distance = new HashMap<String, Integer>();
    	// start 和 end 需要加入到dict里面
    	dict.add(start);
        dict.add(end);
    	//BFS
    	bfs(neighborMap, distance, start, end, dict);
    	//DFS
    	dfs(result, item, neighborMap, distance, end, start);
    	return result;
    }
    
    //BFS，主要完成两件事：
    //1. 构造出每个节点的所有neighbor(neighborMap)
    //2. 构造出每个节点到start的距离(distance)
    private void bfs(HashMap<String, ArrayList<String>> neighborMap, HashMap<String, Integer> distance, String start, String end, HashSet<String> dict) {
    	LinkedList<String> queue = new LinkedList<String>();
    	queue.offer(start);
    	distance.put(start, 0); // start与start之间距离为0
    	// 初始化neighborMap，为后面添加内容做准备（neighborMap.get(nextStr).add(curStr)）;
    	for (String str : dict) {
    		neighborMap.put(str, new ArrayList<String>());
    	}
    	//BFS
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			String curStr = queue.poll();
    			ArrayList<String> curNeighbors = findNeighbors(curStr, dict);
    			for (String nextStr : curNeighbors) {
    				// 此处之所以不写成neighborMap.get(cur).add(neighbor) 是因为之后我们要从end往start寻找，所以要反着来构造neighborMap
    				neighborMap.get(nextStr).add(curStr);
    				if (!distance.containsKey(nextStr)) {
    					distance.put(nextStr, distance.get(curStr) + 1);
    					queue.offer(nextStr);
    				}
    			}
    		}
    	}
    }
    
    //DFS 从end往start的方向找sequence。这样可以剪很多非法枝
    private void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> item, HashMap<String, ArrayList<String>> neighborMap, HashMap<String, Integer> distance, String curStr, String start) {
    	item.add(curStr); //当前元素肯定是sequence中的一个string，所以加入item中
    	if (curStr.equals(start)) {
    		Collections.reverse(item); // 因为item是从end到start的顺序构造的，要向恢复从start到end的顺序需要反转；
    		result.add(new ArrayList<String>(item));
    		Collections.reverse(item); // 为了回溯，需要再把item反转回去。
    		//return; 【注】此处不可以return，否则就没有办法在后面回溯了
    	} else { // 如果curStr已经到达start，则肯定需要立刻进行回溯了，所以不再需要尝试curStr的邻居是否符合到达start的距离为1这件事
	    	for (String next : neighborMap.get(curStr)) {
	    		if (distance.containsKey(next) && distance.get(next) + 1 == distance.get(curStr)) { // 表明next是从curStr朝向靠近start方向的节点
	    			dfs(result, item, neighborMap, distance, next, start); // 用next取代curStr，向下一层递归；
	    		}
	    	}
    	}
    	item.remove(item.size() - 1); // 将curStr从item中移除，进行回溯
    }
    
    private ArrayList<String> findNeighbors(String curStr, HashSet<String> dict) {
    	ArrayList<String> neighbors = new ArrayList<String>();
    	for (int i = 0; i < curStr.length(); i++) {
    		char[] curCharArray = curStr.toCharArray();
    		for (char c = 'a'; c <= 'z'; c++) {
        		if (curStr.charAt(i) == c) {
        			continue;
        		}
        		curCharArray[i] = c;
        		String temp = new String(curCharArray);
        		if (dict.contains(temp)) {
        			neighbors.add(temp);
        			//dict.remove(temp); // 此处不能将temp从dict中移除，因为后面的str的neighbor还需要通过dict来获取
        		}
        	}
    	}
    	return neighbors;
    }

}
