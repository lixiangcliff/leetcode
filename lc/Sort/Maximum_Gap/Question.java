package Maximum_Gap;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] num = {0, 9 ,10 ,19};
		System.out.println(q.maximumGap(num));
	}
	/**
	 * https://leetcode.com/problems/maximum-gap/
	 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
		Try to solve it in linear time/space.
		Return 0 if the array contains less than 2 elements.
		You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
	 */
	
	//bucket: http://blog.csdn.net/u012162613/article/details/41936569
	//radix: http://yucoding.blogspot.com/2014/12/leetcode-question-maximum-gap.html
    public int maximumGap(int[] num) {
    	if (num == null || num.length <= 1) {
    		return 0;
    	}
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	for (int val : num) {
    		min = Math.min(val, min);
    		max = Math.max(val, max);
    	}
    	int bkSize = (max - min) / num.length + 1; //【注】桶排序从整体分布上来讲，趋于每个桶里放一个元素
    	int bkCount = (max - min) / bkSize + 1;
    	ArrayList<ArrayList<Integer>> bks = new ArrayList<ArrayList<Integer>>();
    	for (int i = 0; i < bkCount; i++) {
    		bks.add(new ArrayList<Integer>());
    	}
    	for (int val : num) {
    		int idx = (val - min) / bkSize;
    		if (!bks.get(idx).isEmpty()) {//【注】只需记录每个桶内的最小值和最大值即可
    			bks.get(idx).set(0, Math.min(val, bks.get(idx).get(0))); //local min
    			bks.get(idx).set(1, Math.max(val, bks.get(idx).get(1))); // local max
    		} else {
    			bks.get(idx).add(val);
    			bks.get(idx).add(val);
    		}
    	}
    	int preIdx = 0;
    	int gap = (max - min) / (num.length - 1);
    	for (int i = 1; i < bkCount; i++) {
    		if (bks.get(i).isEmpty()) {
    			continue;
    		}
    		//【注】Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)], 所以桶内的元素不需要彼此比较
    		gap = Math.max(gap, bks.get(i).get(0) - bks.get(preIdx).get(1));//桶号大的min - 桶号小的max
    		preIdx = i;
    	}
    	return gap;
    }
}
