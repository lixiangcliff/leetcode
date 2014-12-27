package _3Sum_Closest;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/3sum-closest/
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, 
	 * given array S = {-1 2 1 -4}, 
	 * and target = 1.
	 * 
	 * The sum that is closest to the target is 2. 
	 * (-1 + 2 + 1 = 2).
	 */
	//http://blog.csdn.net/linhuanmars/article/details/19712011
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length <=2){
        	return Integer.MIN_VALUE; // means does not return a normal value;
        }
        //【注】排序不能忘！
        Arrays.sort(num);
        int closest = num[0] + num[1] + num[2] - target;//closest赋初值
        for (int i = 0; i < num.length - 2; i++){
        	//为什么是target - num[i]而不是num[i] - target可以这样理解：
        	//目标是使等式num[i]+num[j]+num[k] = target成立, 也就是使num[j]+num[k] = target-num[i]成立
        	int curClosest = twoSum(num, target - num[i], i+1);//i+1是从i之后第一个数算起
        	if (curClosest == 0){//找到最优解
        		return target;
        	}
        	if (Math.abs(curClosest) < Math.abs(closest)){
        		closest = curClosest;
        	}
        }
        //可以这样理解，返回的是最接近的num[i]+num[j]+num[k]，而closest = num[0]+num[1]+num[2]-target, 所有下面的return值
        return closest + target;
    }
    
    //变形的subroutine,目标是找到两个数，使他们的和最接近target,返回的是他们的和与target的差值
    //http://blog.csdn.net/linhuanmars/article/details/19711387
    private int twoSum(int[] num, int curTarget, int start){
    	if (num == null || num.length <= 1){
    		return Integer.MAX_VALUE;
    	}
    	int l = start;
    	int r = num.length - 1;
    	int curClosest = num[start] + num[start+1] - curTarget; //curClosest赋初值
    	while(l < r){
    		if(num[l] + num[r] == curTarget){ //已经找到最优解
    			return 0;
    		}
    		int tempDiff = num[l] + num[r] - curTarget;//如果当前的l和r的和会更接近target，则更新closet
    		if (Math.abs(tempDiff) < Math.abs(curClosest)){
    			curClosest = tempDiff;
    		}
    		if (num[l] + num[r] < curTarget){
    			l++;
    		}else{
    			r--;
    		}
    	}
    	return curClosest;
    }

}
