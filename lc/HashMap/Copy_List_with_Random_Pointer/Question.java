package Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 */
	
	//【注】画图 http://blog.csdn.net/linhuanmars/article/details/22463599
	public RandomListNode copyRandomList2(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		if (head == null) {
			return null;
		}
		RandomListNode node = head.next;
		RandomListNode copyHead = new RandomListNode(head.label);
		RandomListNode copyPre = copyHead;
		map.put(head, copyHead);// key is the original node, value is the copied node
		while (node != null) {
			RandomListNode copyNode = new RandomListNode(node.label);// 根据node的label，复制出一个内容一样的copyNode
			map.put(node, copyNode);// pair存入map
			copyPre.next = copyNode;// copyList接上copyNode
			copyPre = copyNode;
			node = node.next;
		}
		node = head;
		RandomListNode copyNode = copyHead;
		// 之所以要第二次遍历，因为第一次创建copyNode时，copyNode.random所指向的的那个copyNode可能还不存在呢
		// 所以这一次遍历，通过寻找每个node.random 来连接copyNode.random
		while (node != null) {
			copyNode.random = map.get(node.random);
			node = node.next;
			copyNode = copyNode.next;
		}
		return copyHead;
	}
	
	//手写版
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		if (head == null) {
			return null;
		}
		RandomListNode copyHead = new RandomListNode(head.label);
		map.put(head, copyHead);
		RandomListNode copyPre = copyHead;
		RandomListNode cur = head.next;
		while (cur != null) {
			RandomListNode copyCur = new RandomListNode(cur.label);// 根据cur的label，复制出一个内容一样的copyNode
			map.put(cur, copyCur);// pair存入map
			copyPre.next = copyCur; // 把copy出来的连上
			copyPre = copyCur;
			cur = cur.next;
			
		}
		for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
			RandomListNode src = entry.getKey();
			RandomListNode copy = entry.getValue();
			RandomListNode srcRdm = src.random;
			RandomListNode copyRdm = map.get(srcRdm);
			copy.random = copyRdm;
		}
		return copyHead;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
