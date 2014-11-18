package Search_Insert_Position;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = {1,2};
		System.out.println(searchInsert(A, 3));
	}
	
	//用BST模板，注意下面的【注】的细节
	//即找target，如果找不到就返回一个比target大(在程序中要写成大于等于，下面会解释)的最小值的index（如果A中的都比target小，则返回A最后一个index+1）
	public static int searchInsert(int[] A, int target) {  
	    if(A == null || A.length == 0) {  
	        return 0;  
	    }
	    int start = 0;
	    int end = A.length - 1;
	    while (start + 1 < end) {
	    	int mid = start + (end - start) / 2;
	    	if (A[mid] == target) {
	    		return mid;
	    	}else if (A[mid] < target){
	    		start = mid;
	    	}else {
	    		end = mid;
	    	}
	    }
	    
	    //BST之后，target的值要么为A[start]和A[end]其中之一，要么在A[start]和A[end]之间；
	    
	    //现在找大于或等于target的最小值，之所以要加上等于，是因为 如果A中只有小于等于两个元素，则上面的BST循环会被直接跳过（因为start和end已经直接相邻或相交了）
	    //我们要在此处处理边界情况，即A的长度小于等于2，并且A[start]==target
	    //找大于或等于target的最小值,候选的有start和end，显然A[start]<A[end]，所以我们先试A[start]，如果它符合了（A[start]>target）,那么就不用再看A[end]了
	    if (A[start] >= target) {//【注】，此处不能写成A[start] > target
	    	return start;
	    }
	    //如果A[start]不符，再看A[end]
	    if (A[end] >= target) {
	    	return end;
	    }
	    //如果都不符合，说明A中没有比target大的值，所以返回A的最后一个index+1，即A的长度
	    return A.length;  
	}  
}
