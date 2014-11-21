package Populating_Next_Right_Pointers_in_Each_Node;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//看图！
	//https://github.com/zsxwing/leetcode-java/blob/master/src/main/java/populating_next_right_pointers_in_each_node/PopulatingNextRightPointersinEachNode.java
	 public static void connect(TreeLinkNode root) {
         TreeLinkNode leftMost = root;
         while (leftMost != null) {
             TreeLinkNode p = leftMost;
             while (p.left != null) {
                 p.left.next = p.right;
                 if (p.next != null) {
                     p.right.next = p.next.left;
                     p = p.next;
                 } else {
                     break;
                 }
             }
             leftMost = leftMost.left;
         }
     }



}


  class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { 
    	  val = x; 
      }
  }
 