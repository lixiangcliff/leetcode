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
	//BFS
	//看图！
	//map来维护原来graph里node和新graph里node的对应关系
	//通过遍历原来的graph，得到原来各个node的neighbor，再根据上面map的对应关系找到在新graph里对应的copyNode及其copyNeighborNode。
	//http://blog.csdn.net/linhuanmars/article/details/22715747
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
        	return null;
        }
        //map的key是原graph的node，value是对应的clone出来的node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()) { //BFS
        	UndirectedGraphNode curNode = queue.poll();
        	for(int i = 0;i < curNode.neighbors.size(); i++){
        		if(!map.containsKey(curNode.neighbors.get(i))){//如果map里买没有neighborNode，当然neighborNode对应clone的copyNeighborNode也不存在
        			copyNode = new UndirectedGraphNode(curNode.neighbors.get(i).label);//所以先clone一个copyNeighborNode出来
        			map.put(curNode.neighbors.get(i), copyNode);//然后再把原neighborNode和clone出来的copyNeighborNode一起加入map中
        			queue.offer(curNode.neighbors.get(i));//再把neighborNode放入queue中等待下一轮处理。
        		}
        		//下面一行简单说就是，把clone出来的node，和clone出来的该node的neighbor，连上。
        		//拆分来看：
        		//前半部分map.get(curNode)表示通过当前node找到clone的node
        		//后半部分map.get(curNode.neighbors.get(i)表示通过当前node的neighborNode找到被clone出来的neighborNode
        		//中间的.neighbors.add表示在新的clone出来的图里，把clone的neighborNode加到clone的node的neighbors的list里
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
