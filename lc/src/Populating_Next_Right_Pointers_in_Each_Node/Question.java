package Populating_Next_Right_Pointers_in_Each_Node;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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
	//my way is wrong
	/*public static void connect(TreeLinkNode root) {
		if(root == null){
			return;
		}
        TreeLinkNode leftMost = root;
        while(leftMost != null){ // increment by layer
        	TreeLinkNode p = leftMost;
        	while(p!=null){ //move to its right neighbor //wrong here. p needs to reach bottom layer
        		if (p.next == null){
        			p.left.next = p.right;
        		}else{
        			p.left.next = p.right;
        			p.right.next = p.next.left; 
        		}
        		p = p.next;        		
        	}
        	leftMost =  leftMost.left;
        }
        
    }*/

}


  class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { 
    	  val = x; 
      }
  }
 