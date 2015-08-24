package Sort_Colors;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] A = {2,1,2,0,1,1,2,0,2,};
		q.sortColors(A);
		for (int i : A){
        	System.out.println( i + ",");
        }

	}
	
	/**
	 * https://oj.leetcode.com/problems/sort-colors/
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Note: You are not suppose to use the library's sort function for this
	 * problem.
	 * 
	 * Follow up: A rather straight forward solution is a two-pass algorithm
	 * using counting sort. First, iterate the array counting number of 0's,
	 * 1's, and 2's, then overwrite array with total number of 0's, then 1's and
	 * followed by 2's.
	 * 
	 * Could you come up with an one-pass algorithm using only constant space?
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4048668.html
	//思想类似partition array（分为两堆），此题是分为三堆
	//partition array用一个标记k，将数组分成两堆，一堆<k，另一堆>=k
	//类似地，此题用两个位置标记l和r，将数组分成三堆，l位之前的（包括l位）的数都为0；r位之后的（包括r位）的数都为2；l和r之间的都为1。
	//【注】 与右边交换之后，i不能移动，因为你有可能交换过来是1或是0（如果是0，还需要与左边交换）。而与左边交换后，i就可以向右边移动了。
    public void sortColors(int[] A) {
        if(A == null || A.length == 0){
        	return;
        }
        int l = 0; // l的左边全是0（即0的右边缘）
        int r = A.length - 1; // r的右边全是2
        for (int i = 0; i <= r; i++) { // 【注】要使用i <= r作为边界值。因为right 指向的是未判断的值。所以当i == r时，此值仍然需要继续判断。
        	if (A[i] == 0) {
        		if (A[l] != 0) {
        			swap(A, l, i);
        		}
        		l++; // 只要遇到一个0，l就往右挪一个以便多标记一个0出来（这是因为即使原来A[l]不为0，但是经过swap之后也为0了，需要重新标记0的右边缘了）
        		//【注】i不需停留，可以直接i++；因为从左边换过来的只可能是1，所有的2全部换到右边去了。（因为i是从左往右遍历的）
        	} else if (A[i] == 2) {
        		if (A[r] != 2) {
        			swap(A, i, r);
        		}
        		r--;
        		i--; //【注】i需停留，因为换过来的有可能是0，所以i要停留来处理掉这个0
        	}
        }
        return;
    }
    
    private void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
