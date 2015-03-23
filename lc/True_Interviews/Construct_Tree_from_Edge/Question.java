package Construct_Tree_from_Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> e1 = new ArrayList();
		e1.add(1);
		e1.add(2);
		ArrayList<Integer> e2 = new ArrayList();
		e2.add(1);
		e2.add(3);
		ArrayList<Integer> e3 = new ArrayList();
		e3.add(3);
		e3.add(4);
		ArrayList<Integer> e4 = new ArrayList();
		e4.add(4);
		e4.add(5);
		ArrayList<Integer> e5 = new ArrayList();
		e5.add(4);
		e5.add(6);
		ArrayList<ArrayList<Integer>> es = new ArrayList<ArrayList<Integer>>();
		es.add(e1);
		es.add(e2);
		es.add(e3);
		es.add(e4);
		es.add(e5);
		Question q = new Question();
		TreeNode root = q.constructTree(es);
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				System.out.print(node.val + ","); 
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			System.out.println("\n=======");
			
		}
		
		/*
		 * 			1
		 * 		   / \
		 * 		  2   3
		 * 			 /
		 * 			4   
		 * 		   / \
		 * 		  5   6
		 */
	}
	
	/**
	 *  Build a tree out of given edges(parentId, childId)
	 * http://www.glassdoor.com/Interview/Find-the-deepest-node-in-a-binary-tree-Build-a-tree-out-of-given-edges-etc-QTN_887354.htm
	 */
	
	//http://stackoverflow.com/questions/14765164/how-to-make-binary-tree-from-edges
	public TreeNode constructTree(ArrayList<ArrayList<Integer>> edges) {
		if (edges == null || edges.size() == 0) {
			return null;
		}
		HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (ArrayList<Integer> edge : edges) {
			int p = edge.get(0);
			int c = edge.get(1);
			if (!map.containsKey(p)) {
				TreeNode pNode = new TreeNode(p);
				map.put(p, pNode);
			}
			if (!map.containsKey(c)) {
				TreeNode cNode = new TreeNode(c);
				map.put(c, cNode);
			}
			TreeNode pNode = map.get(p); 
			TreeNode cNode = map.get(c);
			if (pNode.left != null) {
				pNode.right = cNode;
			} else {
				pNode.left = cNode;
			}
			set.add(p);
		}
		//如果set中的数，是任何edge中childId，则将其从set中剔除
		for (ArrayList<Integer> edge : edges) {
			int c = edge.get(1);
			if (set.contains(c)) {
				set.remove(c);
			}
		}
		if (set.size() != 1) {
			return null;
		} else {
			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				int p = it.next();
				return map.get(p);
			}
		}
		return null;
	}
	

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
