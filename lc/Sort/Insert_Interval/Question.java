package Insert_Interval;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/insert-interval/
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary). You may assume that the intervals were
	 * initially sorted according to their start times. 
	 * Example 1: 
	 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]. 
	 * Example 2: 
	 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
	 * [1,2],[3,10],[12,16]. 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 */
	
	//看图！
	//http://blog.csdn.net/linhuanmars/article/details/22238433
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		int size = intervals.size();
		if (intervals == null || size == 0) {
			result.add(newInterval);
			return result;
		}
		int i = 0;
		while (i < size && intervals.get(i).end < newInterval.start) { // 处理newInterval.start之前所有的interval
			result.add(intervals.get(i));
			i++;
		}
		if (i < size) { // 确定最终的newInterval.start
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start); 
		}
		while (i < size && intervals.get(i).start <= newInterval.end) {// 确定最终的newInterval.end（这期间可能跨过多个interval）
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			i++;
		}
		result.add(newInterval);// 处理完newInterval的所有overlap，把newInterval加入结果集
		while (i < size) { // 把原来list里剩余的interval都加到结果集
			result.add(intervals.get(i));
			i++;
		}
		return result;
	}
}


 class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }