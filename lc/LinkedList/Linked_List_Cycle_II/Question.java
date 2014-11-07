package Linked_List_Cycle_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://answer.ninechapter.com/solutions/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null){
        	return null;
        }
        ListNode walker = head;
        ListNode runner = head;
        //找到w和r的相遇点（如果不相遇，说明没有cycle，则返回null）
        while(true){
            //【注】要先检查runner.next和runner.next.next是否为null。然后才能move
            if(runner.next == null || runner.next.next == null){
        		return null;
        	}
        	walker = walker.next;
        	runner = runner.next.next;
        	if (walker == runner){
        		break;
        	}
        }
        //让head从头，walker从刚才w&r相遇点，同时出发。当head和walker再相遇时候的node，即为cycle的起点
        //具体解释看图
        while(walker != head){
        	walker = walker.next;
        	head = head.next;
        }
        return head;
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
