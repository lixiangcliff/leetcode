package Design_Data_structure_insert_and_query_OlgN_time;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDS ds = new MyDS();
/*		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);*/
		
		ds.insert(4);
		ds.insert(5);
		ds.insert(3);
		System.out.println(ds.query(4));
		ds.insert(1);
		System.out.println(ds.query(4));
		
/*		ds.insert(4);
		ds.insert(2);
		ds.insert(1);
		ds.insert(3);
		ds.insert(6);
		ds.insert(5);
		ds.insert(7);
		System.out.println(ds.query(1));
		System.out.println(ds.query(2));
		System.out.println(ds.query(3));
		System.out.println(ds.query(4));
		System.out.println(ds.query(5));
		System.out.println(ds.query(6));
		System.out.println(ds.query(7));*/
		
		
		
	}
	
	
	/**
	 * http://www.mitbbs.com/article_t/JobHunting/33052881.html
	 * 设计一个数据结构，包括两个操作
		void insert(int d): 插入一个int
		int query(int d): 查询d在数据结构中的排名
		
		example: 
		Insert: 4, 5, 3
		query(4) gives 2; 
		insert: 1
		query(4) gives 3;
		
		
		如何设计保证两个操作都是O(log(n))?
	 */
	
	/*
	 * BST带RANK。每个接点存一个INT做RANK，表示这个节点左子树大小。
		插入的时候在找插入位置的过程中，如果当前节点要往左走，则把当前节点的RANK加一。
		查询的时候，在查找元素的过程中，如果当前节点要往右走，累加当前节点的RANK。
	 */
	
	

}

class MyDS {
	private TreeNode dummy = new TreeNode(Integer.MAX_VALUE); // all node reside on its left sub-tree
	
	//void insert(int d): 插入一个int
	void insert(int d) {
		TreeNode cur = dummy.left;
		if (cur == null) {
			dummy.left = new TreeNode(d);
		}
		TreeNode pre = dummy;
		while (cur != null) {
			if (d < cur.val) {
				cur.rank += 1; 
				pre = cur;
				cur = cur.left;
				if (cur == null) {
					pre.left = new TreeNode(d);
				}
			} else {
				pre = cur;
				cur = cur.right;
				if (cur == null) {
					pre.right = new TreeNode(d);
				}
			}
		}
	}
	
	//int query(int d): 查询d在数据结构中的排名
	int query(int d) {
		int pos = 1;
		TreeNode cur = dummy.left;
		if (cur == null) {
			return 0; // means empty
		}
		while (cur != null) {
			if (d < cur.val) {
				cur = cur.left;
				if (cur == null) {
					return -1; // faild to find d in MyDS
				}
			} else if (d > cur.val) {
				pos += (cur.rank + 1); // +1是因为也要加上cur这个元素
				cur = cur.right;
				if (cur == null) {
					return -1; // faild to find d in MyDS
				}
			} else {
				return pos + cur.rank;
			}
		}
		return -1;
	}
	
}


class TreeNode {
	int val;
	int rank; // how many children it has on its left sub-tree
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val) {
		this.val = val;
		this.rank = 0;
		this.left = null;
		this.right = null;
	}
	
}