package Linked_List_Cycle;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21200601
    public static boolean hasCycle(ListNode head) {
        if(head ==null || head.next == null){//head.next==null就是说只有一个node
            return false;
        }
        ListNode current = head;
        ListNode runner = head;
        while(runner != null && runner.next !=null){
        	current = current.next;
        	runner = runner.next.next;
        	if (current == runner){
        		return true;
        	}
        }
        //runner已经跑到最后了current和runner仍然没有相遇，则返回false
        return false;
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