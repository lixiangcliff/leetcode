package Container_With_Most_Water;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] matrix = {1,2,3,4,5};
		int[] matrix = {2,1};
		System.out.println(maxArea(matrix));

	}
	
	//Time Limit Exceeded error from leet code
/*    public static int maxArea(int[] height) {
    	int max = 0;
    	for(int i=0; i<height.length-1;i++){
    		for(int j=i+1;j<height.length;j++){
    			int shorter = height[i] < height[j] ? height[i] : height[j];
    			int area = (j-i)*shorter;
    			max = area > max ? area : max;
    		}
    	}
        return max; 
    }*/
	
	//idea from http://answer.ninechapter.com/solutions/container-with-most-water/
	// for any i, the maxium area will be the farthest j that has a[j] > a[i];
	// http://blog.csdn.net/wzy_1988/article/details/17248209
	public static int maxArea(int[] height) {
		if (height== null || height.length < 2){
			return 0;
		}
    	int max = 0;
    	int left = 0;
    	int right = height.length-1;
    	while (left < right){
    		max = Math.max(max, Math.min(height[left], height[right])*(right-left) );
    		if (height[left] < height[right]){ //means left is the smaller one--the bottleneck, we want to move to right trying to find a bigger left
    			left++;
    		} else{
    			right--;
    		}
    	}
        return max; 
    }
}
