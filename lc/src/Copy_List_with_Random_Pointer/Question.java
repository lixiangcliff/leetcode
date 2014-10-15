package Copy_List_with_Random_Pointer;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22463599
    public RandomListNode copyRandomList(RandomListNode head) {
       HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
       if (head == null){
    	   return null;
       }
       RandomListNode node = head.next;
       RandomListNode newHead = new RandomListNode(head.label);
       RandomListNode newRunner = newHead;
       map.put(head, newHead);// key is the original node, value is the copied(new) node
       while(node!=null){
    	   RandomListNode newNode = new RandomListNode(node.label);
    	   map.put(node, newNode);
    	   newRunner.next = newNode;
    	   newRunner = newNode;
    	   node = node.next;
       }
       node = head;
       RandomListNode newRandom = newHead;
       while(node!=null){
    	   newRandom.random = map.get(node.random);//node.random is key;
    	   node = node.next;
    	   newRandom = newRandom.next;
       }
       return newHead;
    }

}

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
