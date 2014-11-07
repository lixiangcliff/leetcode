package Reverse_Nodes_in_k_Group;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = l1;
		while(head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		ListNode head2 = reverseKGroup(l1, 2);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
	}
	
	//my way;
/*    public static ListNode reverseKGroup(ListNode head, int k) {
    	if (k==1){
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode cur = head;
    	ListNode tail = dummy;
    	while(cur != null){
    		ListNode groupDummy = new ListNode(0);
    		ListNode groupTail = cur;
    		int i = 0;
    		ListNode runner = cur;
    		while(runner != null && i<k){
    			runner = runner.next; // cannnot be missed
    			i++;
    		}
    		boolean enoughK = i == k? true : false;
    		i=0;
    		if (enoughK){
				while(cur != null && i<k){
					ListNode next = cur.next; // cur.next must be kept before doing manipulation on cur, otherwise cur.next will change 
					cur.next = groupDummy.next;
					groupDummy.next = cur;
					if (i==0){
						groupTail = cur;
					}
					cur = next;
					i++;
				}
					tail.next = groupDummy.next;
					tail = groupTail;
    		}else{
    			tail.next = cur;
    			break;
    		}
    	}
    	return dummy.next;
    }*/
    
    //http://blog.csdn.net/linhuanmars/article/details/19957455
    //need to understand "reverse" function well
	public static ListNode reverseKGroup(ListNode head, int k) {  
	    if(head == null)  
	    {  
	        return null;  
	    }  
	    ListNode dummy = new ListNode(0);  
	    dummy.next = head;  
	    int count = 0;  
	    ListNode pre = dummy;  
	    ListNode cur = head;  
	    while(cur != null) {  
	        count ++;  
	        ListNode next = cur.next; //要提前把cur.next存好。不然如果经过if里面的处理, 再取cur.next，取的就不是原来的了
	        if(count == k){  // only do reverse when reach to k nodes
	            pre = reverse(pre, next);  // 新的pre往右挪了k个node的位子
	            count = 0;     
	        }  
	        cur = next;  
	    }  
	    return dummy.next;  
	}  
	/*这个函数不但把pre和end之间的所有node reverse了，而且保证reverse之后，中间被reverse的node 左边仍连接平pre 右边仍连接end
	 * 关于这个函数的两个参数pre 和 end
	 * pre的下一个node是k个node里面的第1个
	 * end的前一个node是k个node里面的第k个
	 * 换言之：pre和end之间夹的node一共有k个
	 */
	private static ListNode reverse(ListNode pre, ListNode end) {  
	    if(pre==null || pre.next==null){  
	        return pre;  
	    }
	    //把head保留起来，reverse之后和end接上
	    ListNode head = pre.next;  
	    ListNode cur = pre.next.next;  
	    while(cur!=end) {  
	        ListNode next = cur.next;  
	        cur.next = pre.next;  
	        pre.next = cur;  // connect from "left" side每一轮都把右边挪过来的node和左边的pre接上
	        cur = next;  
	    }  
	    head.next = end;  // connect from "right" side (connect kth node to k.next)最后把之前保留好的head和end接上
	    return head;  // 返回的head作为下一轮新的pre（如果还有下一轮的话）
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
