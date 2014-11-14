package Convert_Sorted_Array_to_Binary_Search_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,9};
		

	}
	//http://blog.csdn.net/linhuanmars/article/details/23904883
	public TreeNode sortedArrayToBST(int[] num) {
		if(num ==null || num.length == 0){
			return null;
		}
		return helper(num, 0, num.length-1);
    }
	
	private TreeNode helper(int[] num, int l, int r) {
		if(l > r){
			return null;
		}
		int m = (l + r)/2;
		TreeNode root = new TreeNode(num[m]);//以当前数组的中间值，来create根节点
		root.left = helper(num, l, m-1); //当前root的左孩子为左半边数组的递归返回值
		root.right = helper(num, m+1, r);//右孩子类似
		return root;
	}
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
