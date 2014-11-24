package Populating_Next_Right_Pointers_in_Each_Node;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//看图！
	// http://www.ninechapter.com/solutions/populating-next-right-pointers-in-each-node/
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode parent = root;
		TreeLinkNode nextLevelLeftMost = parent.left;
		// 处理整个树
		while (nextLevelLeftMost != null) {
			TreeLinkNode pre = null; //用这个pre将parent这一样node的所有孩子们连接起来
			// 处理parent这个node所在的那一行
			while (parent != null) { //（除了第一次循环只处理一个孩子外，其余每次处理两个孩子）--（即除第一次外，每次循环pre右移两次）。具体的，看图！）
				if (pre == null) { //单独处理pre是最左边的node时的情况
					pre = parent.left; 
				} else { //上一个parent的右孩子脸上当前parent的左孩子
					pre.next = parent.left;
					pre = pre.next;
				}
				pre.next = parent.right; //当前parent的左孩子连上其右孩子
				pre = pre.next; // pre移向其右边
				parent = parent.next; //parent移向其右边
			}
			parent = nextLevelLeftMost;
			nextLevelLeftMost = parent.left;
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
 