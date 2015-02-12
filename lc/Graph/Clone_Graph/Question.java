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
	
	/**
	 * https://oj.leetcode.com/problems/clone-graph/
	 * Clone an undirected graph. Each node in the graph contains a label and a
	 * list of its neighbors.
	 */
	//BFS + HashMap 看图！
	//map来维护原来graph里node和新graph里node的对应关系。遍历原图时，用HashMap可以区分地处理哪些neighbor node已经clone，哪些还没有。
	//通过遍历原来的graph，得到原来各个node的neighbor，再根据上面map的对应关系找到在新graph里对应的copyNode及其copyNeighborNode。
	//http://blog.csdn.net/linhuanmars/article/details/22715747
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        //map的key是原graph的node，value是对应的clone出来的node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()) { //BFS 【注】下面过程看着图更容易一步步写出来
        	UndirectedGraphNode curNode = queue.poll();
        	for (UndirectedGraphNode nbr : curNode.neighbors) {
        		if (!map.containsKey(nbr)) {// 1.如果还未clone过这个neighbor，则clone之
        			copyNode = new UndirectedGraphNode(nbr.label);//那么就先clone一个nbr的copy节点：copyNode，出来
        			map.put(nbr, copyNode);//然后再把nbr和clone出来的copyNode一起加入map中
        			queue.offer(nbr);//再把nbr放入queue中等待下一轮处理。
        		}
        		map.get(curNode).neighbors.add(map.get(nbr)); //2.把clone出来的node，和clone出来的该node的neighbor，连上。
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
