package Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//BFS
	//http://blog.csdn.net/linhuanmars/article/details/22715747
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
        	return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while(!queue.isEmpty()){
        	UndirectedGraphNode curNode = queue.poll();
        	for(int i=0;i<curNode.neighbors.size();i++){
        		if(!map.containsKey(curNode.neighbors.get(i))){//map doesn't contain curNode.neighbors.get(i) means: this UndirectedGraphNode does not exist in "copy graph" yet, so we need to make one
        			copyNode = new UndirectedGraphNode(curNode.neighbors.get(i).label);
        			map.put(curNode.neighbors.get(i), copyNode);
        			queue.offer(curNode.neighbors.get(i));
        		}
        		//add curNode.neighbors.get(i) into copy graph's node's neighbor's arraylist;
        		map.get(curNode).neighbors.add(map.get(curNode.neighbors.get(i)));
        	}
        }
        return map.get(node);
    }

}


 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { 
    	 label = x; 
    	 neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
