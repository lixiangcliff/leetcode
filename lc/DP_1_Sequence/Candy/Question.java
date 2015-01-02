package Candy;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {1,2,3,2,4,2};
		System.out.println(candy(ratings));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21424783
    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
        	return 0;
        }
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        for(int i=1;i<ratings.length;i++){
        	// if ratings[i] == ratings[i-1], it is ok to let ratings[i]==1;
        	nums[i] = ratings[i]> ratings[i-1] ? nums[i-1]+1 : 1;
        }
        int result = nums[ratings.length-1];
        for(int i=ratings.length-2; i>=0; i--){
        	int current = 1;
        	if(ratings[i]> ratings[i+1]){
        		//current = ratings[i+1]+1; //wrong!!
        		current = nums[i+1]+1;
        	}
        	result += Math.max(current, nums[i]);
        	nums[i] = current;
        }
        return result;
    }

}
