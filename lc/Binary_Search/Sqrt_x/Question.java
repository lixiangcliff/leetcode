package Sqrt_x;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(2147395599));

	}
	
	//using BST template
	//http://blog.csdn.net/linhuanmars/article/details/20089131
    public static int sqrt(int x) {
    	if(x<0){
    		return -1;
    	}
    	if(x<=1){
    		return x;
    	}
    	int start = 1;
    	//【注】 当x>=2时， 有x/2 >= sqrt(x) 恒成立。所以可以取end = x/2作为 sqrt(x)的上界
    	int end = x / 2;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		//下面条件即是 mid^2 <= x < (mid+1)^2 但是需要除法代替乘法。道理和上面mid=start+(end-start)/2一样，都是为了避免overflow
    		if (mid <= x / mid && (mid + 1) > x / (mid + 1)) { //夹逼找到所求值
    			return mid;
    		} else if (mid < x / mid) { //mid^2 < x
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (start <= x / start && (start + 1) > x / (start + 1)){
    		return start;
    	} else {
    		return end;
    	}
    }
	
}
