package Largest_Rectangle_in_Histogram;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
    public static int largestRectangleArea(int[] height) {
    	return 0;
        
    }
	
/*	public static int largestRectangleArea(int[] height) {  
	    if(height==null || height.length==0)  
	        return 0;  
	    int max = 0;  
	    LinkedList<Integer> stack = new LinkedList<Integer>();  
	    for(int i=0;i<height.length;i++)  
	    {  
	        while(!stack.isEmpty() && height[i]<=height[stack.peek()])  
	        {  
	            int index = stack.pop();  
	            int curArea;
	            if (stack.isEmpty()){
	            	curArea = i*height[index];
	            }else{
	            	curArea = (i-stack.peek()-1)*height[index];
	            }
	            max = Math.max(max,curArea);  
	        }  
	        stack.push(i);  
	    }  
	    while(!stack.isEmpty())  
	    {  
	        int index = stack.pop();  
	        int curArea = stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];  
	        max = Math.max(max,curArea);              
	    }  
	    return max;  
	} */ 

}
