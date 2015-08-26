package Populating_Next_Right_Pointers_in_Each_Node_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
	 * Follow up for problem "Populating Next Right Pointers in Each Node".
		What if the given tree could be any binary tree? 
		Would your previous solution still work?
		
		Note:
		You may only use constant extra space.
		
		For example,
		Given the following binary tree,
		         1
		       /  \
		      2    3
		     / \    \
		    4   5    7
		    
		After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \    \
		    4-> 5 -> 7 -> NULL
	 */
	
	//此题的技巧在于设置一个dummy(pre初值为dummy)，dummy.next来标记下一行最左端的node。
	//当前cur从左到右遍历当前行时，就把下面的一行用pre“织”起来了。
	//然后进入下一行时，只需将cur置为dummy.next即可。
	//http://www.cnblogs.com/yuzhangcmu/p/4041345.html
	public void connect(TreeLinkNode root) {
		if (root == null){
        	return;
        }
		TreeLinkNode cur = root;
		while (cur != null) {//处理整棵树
			TreeLinkNode dummy = new TreeLinkNode(0); // 每一行都要重新做一个dummy，以及重新标记pre
			TreeLinkNode pre = dummy;
			while (cur != null) { //处理每行
				if (cur.left != null) {
					pre.next = cur.left; //把pre之前所指向的node接在cur.left上
					pre = pre.next; //更新pre
				}
				if (cur.right != null) {
					pre.next = cur.right; 
					pre = pre.next;
				}
				cur = cur.next;
			}
			cur = dummy.next;
		}
	}
	
	//recursive way
	//http://www.cnblogs.com/Jam01/p/3633203.html
    public void connectRecursive(TreeLinkNode root) {
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
