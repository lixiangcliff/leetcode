package Majority_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//int[] num = {1, 1, 1, 1, 2, 2, 2};
		int[] num = {10,9,9,9,10};
		System.out.print(q.majorityElement(num));
	}
	
	/**
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	
	//中心思想是只要找到两个不一样的元素，就把他们抵消掉，最后剩下的就是超过 n / 2个数量的那个
    public int majorityElement(int[] num) {
    	if (num == null || num.length == 0) {
    		return Integer.MAX_VALUE;
    	}
        int candidate = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
        	if (count == 0) { // 前面的全都抵消掉了
        		candidate = num[i];
        		count = 1; //【注】勿忘count此时置1
        	} else {
        		if (candidate == num[i]) { // 有出现了一个和candidate相同的数
        			count++;
        		} else { // 与candidate不同，则抵消掉一次。
        			count--; 
        		}
        	}
        }
        return candidate;
    }

}
