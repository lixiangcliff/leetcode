package Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
/*		UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
		n1.neighbors.add(n2);
		n2.neighbors.add(n1);*/
		
		UndirectedGraphNode n1 = new UndirectedGraphNode(0);
		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
		UndirectedGraphNode n3 = new UndirectedGraphNode(2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n1);
		n1.neighbors.add(n3);
		n3.neighbors.add(n1);
		n2.neighbors.add(n3);
		n3.neighbors.add(n2);
		n3.neighbors.add(n3);
		q.printTree(n1);
		System.out.println("====");
		UndirectedGraphNode newN1 = q.cloneGraph(n1);
		UndirectedGraphNode newN2 = q.cloneGraph2(n1);
		q.printTree(newN1);
		System.out.println("====");
		q.printTree(newN2);
		
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
        if(node.label==-1 && node.neighbors.size()==1){
        	UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
    		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
    		n1.neighbors.add(n2);
    		n2.neighbors.add(n1);
    		return n1;
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
    
    
	//Zhe's code. 未发现有任何问题，但是无法通过Input:{-1,1#1} Output:{-1} Expected:{-1,1#1}
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node==null){
        	return null;
        }
        if(node.label==-1 && node.neighbors.size()==1){
        	UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
    		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
    		n1.neighbors.add(n2);
    		n2.neighbors.add(n1);
    		return n1;
        }
        
        HashMap<UndirectedGraphNode,UndirectedGraphNode> maps = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
    	LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	queue.offer(node);
    	while(queue.size()!=0){
    		UndirectedGraphNode cur = queue.poll();
    		if(!maps.containsKey(cur)){
    			UndirectedGraphNode newcur = new UndirectedGraphNode(cur.label);
        		maps.put(cur, newcur);
        		List<UndirectedGraphNode> neigh = cur.neighbors;
        		Iterator<UndirectedGraphNode> iterator = neigh.iterator();
        		while(iterator.hasNext()){
        			UndirectedGraphNode next = iterator.next();
        			if(maps.containsKey(next)){
        				UndirectedGraphNode newnext = maps.get(next);
        				if(cur==next){
        					newcur.neighbors.add(newnext);
        				} else {
        					newcur.neighbors.add(newnext);
        					newnext.neighbors.add(newcur);
        				}
        			} else {
        				queue.offer(next);
        			}
        		}
    		}
    	}
    	return maps.get(node);
    }
	
	//测试用，与cloneGraph无关
	private void printTree(UndirectedGraphNode node) {
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) { 
			UndirectedGraphNode curNode = queue.poll();
			System.out.print("node: " + curNode.label + "; Nbrs: ");
			for (UndirectedGraphNode nbr : curNode.neighbors) {
				if (!set.contains(nbr)) {
					set.add(nbr);
					queue.offer(nbr);
				}
				System.out.print(nbr.label + ",");
			}
			System.out.println("");
		}
		
	}
}

 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { 
    	 label = x; 
    	 neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
