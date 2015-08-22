package Merge_k_Sorted_Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://oj.leetcode.com/problems/merge-k-sorted-lists/ 
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 */
	
	//******divide and conquer method******
	//【注】递归边界最好的办法是举例！
	//http://www.cnblogs.com/yuzhangcmu/p/4146119.html
	//http://blog.csdn.net/linhuanmars/article/details/19899259
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
			return null;
		}
		return helper(lists, 0, lists.length- 1);
    }
    
    //返回的是将left和right merge之后的新的head node
    //先把k个list分成两半，然后继续划分，直到剩下两个list就合并起来。
	//【注】关于如何取分治递归的边界，以及mid是向上还是向下取整
	//这个问题这样想： 1.先假设mid向下取整。2.再根据mid的值来确定递归中helper参数的边界。
	//比如：当mergeTwoLists的两个参数分别为：helper(lists, left, mid) , helper(lists, mid + 1, right)
	//比如假设当前helper里参数为left和right。且赋值left == 0, right == 1
	//
	//1.向下取整，则mid = left + (right - left) / 2 = 0;
	//2.递归时参数边界有可能有两种情况：
	//	1）helper(lists, left, mid - 1) , helper(lists, mid, right)
	//	2）helper(lists, left, mid) , helper(lists, mid + 1, right)
	// 带入left和right的值后，则有
	//	1）helper(lists, 0, -1) , helper(lists, 0, 1) // 一个无意义；另一个和此层函数完全一样，导致死循环
	//	2）helper(lists, 0, 0 , helper(lists, 1, 1) // 两个都正确合理
	//
	// 结论：当mid向下取整时，递归函数为helper(lists, left, mid) , helper(lists, mid + 1, right)
	//则helper(lists, left, mid) , helper(lists, mid+1, right) 变为 helper(lists, 0, 1) , helper(lists, 2, 1)
	private ListNode helper(ListNode[] lists, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;// 向下取整，同时避免溢出
			return mergeTwoLists(helper(lists, left, mid), helper(lists, mid + 1, right));
		}
		return lists[left];// or return lists[right] 最后的时候left == right;
	}

    //完全照搬 https://oj.leetcode.com/problems/merge-two-sorted-lists/
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if (l1 != null) {
			pre.next = l1;
		} else {
			pre.next = l2;
		}
		return dummy.next;
	}
    
    //heap method
    public ListNode mergeKListsHeap(ArrayList<ListNode> lists) {
    	//【注】：构造PriorityQueue(capacity)时， capacity的值可以随便给个正整数，比如10，如果以后不够大了，它会自动增长
    	//但是不能给capacity赋值为lists.size()，这是因为testcase里 lists有可能为空(capacity<1)，会抛出IllegalArgumentException 
    	PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>(){
    		@Override
    		public int compare(ListNode node1, ListNode node2){
    			return node1.val - node2.val;
    		}
    	});
    	
    	//取lists中每个链表的表头（如果表头不为空），存入heap组成一个size为k的heap
    	for(int i = 0; i < lists.size(); i++){
    		ListNode node = lists.get(i);
    		if (node!= null){
    			heap.offer(node);
    		}
    	}
    	
    	ListNode dummy = new ListNode(0);
    	ListNode pre = dummy;//待返回的链表的表尾
    	
    	while(heap.size()>0){
    		//取出heap顶node
    		ListNode cur = heap.poll();
    		//待返回的链表的表尾接上这个取出的node
    		pre.next = cur;
    		//如果被取出的node在原链表中的next不为null，则取该next并补充放入heap
    		if (cur.next != null){
    			heap.offer(cur.next);
    		}
    		//更新待返回的链表的表尾
    		pre = cur;
    	}
    	return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}