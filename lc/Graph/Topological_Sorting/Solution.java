package Topological_Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		int [] num = {1,2,3};
		Solution q = new Solution();
		ArrayList<ArrayList<Integer>> result = q.topSort(num);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}*/
	}

	/**
	 * http://www.lintcode.com/en/problem/topological-sorting/
	 * Given an directed graph, a topological order of the graph nodes is defined as follow:

		For each directed edge A -> B in graph, A must before B in the order list.
		The first node in the order can be any node in the graph with no nodes direct to it.
		Find any topological order for the given graph.
		
		Have you met this question in a real interview? Yes
		Example
		For graph as follow:
		
		https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThE9AgZZszyhwe0o9qpp3VyizdIj9kWwMY50HiQEysXvkSLsoZ
		
		
		The topological order can be:
		
		[0, 1, 2, 3, 4, 5]
		[0, 2, 3, 1, 5, 4]
		...
		Note
		You can assume that there is at least one topological order in the graph.
	 */
	
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
    	if (graph == null || graph.size() <= 1) {
    		return graph;
    	}
    	HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>(); // <node, 该node的入度>
    	//统计每个node的入度
    	for (DirectedGraphNode node : graph) {
    		for (DirectedGraphNode nextNode : node.neighbors) {
    			if (map.containsKey(nextNode)) {
    				map.put(nextNode, map.get(nextNode) + 1);
    			} else {
    				map.put(nextNode, 1);
    			}
    		}
    	}
    	LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    	for (DirectedGraphNode node : graph) {
    		if (!map.containsKey(node)) { // 入度为“0”，即“起点”
    			queue.offer(node);
    			res.add(node);
    		}
    	}
    	while (!queue.isEmpty()) { 
    		DirectedGraphNode node = queue.poll();
    		for (DirectedGraphNode nextNode : node.neighbors) {
    			if (map.containsKey(nextNode)) {
        			map.put(nextNode, map.get(nextNode) - 1); //入度减一
    				if (map.get(nextNode) == 0) { //依次从map里剔除入度为0的node
        				queue.offer(nextNode); //入度为0的可以放入queue中
            			res.add(nextNode); // 入度为0的加入结果集中
            			map.remove(nextNode);
        			} 
    			}
    		}
    	}
    	return res;
    }
}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};
