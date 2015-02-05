package Add_Two_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ListNode l1 = new ListNode(2);
		ListNode l1b = new ListNode(4);
		ListNode l1c = new ListNode(3);
		l1.next = l1b;
		l1b.next = l1c;
		
		ListNode l2 = new ListNode(5);
		ListNode l2b = new ListNode(6);
		ListNode l2c = new ListNode(4);
		l2.next = l2b;
		l2b.next = l2c;
		
		//ListNode l1 = new ListNode(0);
		//ListNode l1b = new ListNode(8);
		//l1.next = l1b;
		//ListNode l2 = new ListNode(0);
		ListNode result = q.addTwoNumbers(l1, l2);
		while(result != null){
			System.out.println(result.val + ",");
			result = result.next;
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/add-two-numbers/
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
	 * Output: 7 -> 0 -> 8
	 */
	
	// 类似 Add_Binary
	// 本题链表表示数字的规则如下： 表头为最低位，表尾为最高位
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		int carry = 0;
		// 【注】技巧：设置一个dummy的node，令dummy.next为结果的head，返回的时候只需返回dummy.next即可
		// 不这样做直接用pre来表示head，的坏处是：要先给pre设好初值(即整个循环体部分)，然后再进入循环体（相当于循环体被写了两遍）
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (l1 != null || l2 != null) {
			int l1Value = l1 == null ? 0 : l1.val; // l1不为null 才可以取l1的值
			int l2Value = l2 == null ? 0 : l2.val;
			int value = l1Value + l2Value + carry;
			int digit = value % 10;
			carry = value / 10;
			ListNode cur = new ListNode(digit);
			pre.next = cur;
			pre = cur;
			if (l1 != null) { // 【注】步进时需要check当前node是不是null
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry == 1) { // 此时carry仍为1，说明加和比两个数中位数多的那个还要多一位。则再链表结尾加一个val==1的node（即数字开头加1）
			pre.next = new ListNode(1);
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