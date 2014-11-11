package Populating_Next_Right_Pointers_in_Each_Node_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://www.cnblogs.com/Jam01/p/3633203.html
    public void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        TreeLinkNode p = root.next;
        //to find the first valid "next" of current.right
        while(p!=null){
        	if(p.left != null){
        		p = p.left;
        		break;
        	}
        	if(p.right != null){
        		p = p.right;
        		break;
        	}
        	p = p.next;
        }
        
        //to process current.right
        if(root.right != null){
        	root.right.next = p;
        }
        //to process current.left;
        if(root.left != null){
        	root.left.next = root.right != null ? root.right:p;
        }
        
        //recursive right child
        connect(root.right);
        //recursive left child
        connect(root.left);       
    }

}

 class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }
