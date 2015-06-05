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

	}

	/**
	 * http://www.lintcode.com/en/problem/topological-sorting/
	 * Medium Topological Sorting
		Given an directed graph, a topological order of the graph nodes is defined as follow:
		
		For each directed edge A -> B in graph, A must before B in the order list.
		The first node in the order can be any node in the graph with no nodes direct to it.
		Find any topological order for the given graph.
		
		Example
		For graph as follow:
		
		picture https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThE9AgZZszyhwe0o9qpp3VyizdIj9kWwMY50HiQEysXvkSLsoZ
		
		The topological order can be:
		
		[0, 1, 2, 3, 4, 5]
		[0, 2, 3, 1, 5, 4]
		...
		Note
		You can assume that there is at least one topological order in the graph.
		
		Challenge
		Can you do it in both BFS and DFS?
	 */
	
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
	
	//http://www.jiuzhang.com/solutions/topological-sorting/
	//http://www.geeksforgeeks.org/topological-sorting/
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
    		if (!map.containsKey(node)) {
    			queue.offer(node);
    			res.add(node);
    		}
    	}
    	while (!queue.isEmpty()) {
    		DirectedGraphNode node = queue.poll();
    		for (DirectedGraphNode nextNode : node.neighbors) {
    			if (map.containsKey(nextNode)) {
        			map.put(nextNode, map.get(nextNode) - 1);
    				if (map.get(nextNode) == 0) {
        				queue.offer(nextNode);
            			res.add(nextNode);
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
}
