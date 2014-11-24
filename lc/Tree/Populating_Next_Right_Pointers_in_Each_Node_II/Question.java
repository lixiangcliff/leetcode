package Populating_Next_Right_Pointers_in_Each_Node_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//http://www.ninechapter.com/solutions/populating-next-right-pointers-in-each-node-ii/
	public void connect(TreeLinkNode root) {
		//TreeLinkNode nextLevelLeftMost = null;
		if(root == null){
        	return;
        }
		TreeLinkNode parent = root;
		while (parent != null) {//处理整棵树
			TreeLinkNode nextLevelLeftMost = null; //每完成一行都要重新置null
			TreeLinkNode pre = null; //每完成一行都要重新置null
			while (parent != null) {//处理当前parent所在的行
				if (nextLevelLeftMost == null) { //找parent下一行最左的node
					nextLevelLeftMost = parent.left != null ? parent.left : parent.right;
				}
				if (parent.left != null) { //parent左孩子存在，则处理左孩子的向右连接
					if (pre == null) { //pre之前仍未赋值
						pre = parent.left; //给pre赋值
					} else {	//pre之前已经赋值
						pre.next = parent.left; //上一个parent的右孩子连上当前parent的左孩子
						pre = pre.next;
					}
				}
				if (parent.right != null) {
					if (pre == null) { //pre之前仍未赋值
						pre = parent.right; //给pre赋值
					} else {	//pre之前已经赋值
						pre.next = parent.right; //当前parent的左孩子连上其右孩子
						pre = pre.next;
					}
				}
				parent = parent.next; //完成当前node，parent向右移动一个
			}
			parent = nextLevelLeftMost; //完成本行，向下移动一行
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
