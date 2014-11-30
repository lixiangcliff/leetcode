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
	/***********************divide and conquer method below***********************/
	//divide and conquer method
	//http://blog.csdn.net/linhuanmars/article/details/19899259
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if (lists == null ||lists.size() == 0){
    		return null;
    	}
        return helper(lists, 0, lists.size()-1);
    }
    
    //返回的是将left和right merge之后的新的head node
    //先把k个list分成两半，然后继续划分，直到剩下两个list就合并起来。
    private ListNode helper(ArrayList<ListNode> lists, int left, int right){
    	if (left < right){
    		//关于如何取分治的边界，以及mid是向上还是向下取整
    		//这个问题这样想：
    		//先确定helper参数的边界，再确定mid是向上还是向下取整
    		//
    		//比如：当mergeTwoLists的两个参数分别为：helper(lists, left, mid) , helper(lists, mid+1, right)
    		//任意复制left和right。假设 left==0, right==1
    		//
    		//若向上取整，则mid = (left+right+1)/2 = 1;
    		//则helper(lists, left, mid) , helper(lists, mid+1, right) 变为 helper(lists, 0, 1) , helper(lists, 2, 1)
    		//一下子出现两个问题：
    		//1. helper(lists, 0, 1): 和初始时候helper(lists, left, right)的值一模一样 则陷入死循环（分治的原则之一就是要使问题的规模随着分治而变小。这种取整的方式导致规模未变）
    		//2. helper(lists, 2, 1)： 则干脆就越界了
    		//综合以上两点所以不能向上取整
    		//
    		//反之若向下取整，则mid = (left+right)/2 = 0;
    		//则helper(lists, left, mid) , helper(lists, mid+1, right) 变为 helper(lists, 0, 0) , helper(lists, 1, 1)
    		//则没有问题
    		//
    		//int mid = (left+right+1)/2;//向上取整
    		//return mergeTwoLists(helper(lists, left, mid-1) , helper(lists, mid, right));
    		int mid = (left+right)/2;//向下取整
    		return mergeTwoLists(helper(lists, left, mid) , helper(lists, mid+1, right));
    	}
    	return lists.get(left);// or return lists.get(right) 最后的时候left==right;
    }

    //https://oj.leetcode.com/problems/merge-two-sorted-lists/
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }
        return dummy.next;
    }
    
    /***********************heap method below***********************/
    
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