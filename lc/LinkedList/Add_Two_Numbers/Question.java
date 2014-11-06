package Add_Two_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		ListNode l1 = new ListNode(2);
		ListNode l1b = new ListNode(4);
		ListNode l1c = new ListNode(3);
		l1.next = l1b;
		l1b.next = l1c;
		
		ListNode l2 = new ListNode(5);
		ListNode l2b = new ListNode(6);
		ListNode l2c = new ListNode(4);
		l2.next = l2b;
		l2b.next = l2c;*/
		
		ListNode l1 = new ListNode(0);
		//ListNode l1b = new ListNode(8);
		//l1.next = l1b;
		
		ListNode l2 = new ListNode(0);
		
		ListNode result = addTwoNumbers(l1, l2);
		while(result != null){
			System.out.println(result.val + ",");
			result = result.next;
		}
		

		
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null){
    		return null;
    	}
    	int carry = 0;
    	ListNode result = new ListNode(0);
    	ListNode runner = result;
        while(l1 != null || l2 != null){
        	int l1Value = l1 == null ? 0 : l1.val;
        	int l2Value = l2 == null ? 0 : l2.val;
        	int value = l1Value + l2Value + carry;
        	int digit = value % 10;
        	carry = value / 10;
        	ListNode current = new ListNode(digit);
        	runner.next = current;
        	runner = current;
        	if(l1 != null){
        		l1 = l1.next;
        	}
        	if (l2  != null){
        		l2 = l2.next;
        	}
        }
        if (carry == 1){
        	runner.next = new ListNode(1);
        }
        return result.next;
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