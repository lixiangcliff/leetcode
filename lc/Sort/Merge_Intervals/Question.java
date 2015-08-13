package Merge_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/merge-intervals/
	 * Given a collection of intervals, merge all overlapping intervals.
	 * For example, 
	 * Given [1,3],[2,6],[8,10],[15,18], 
	 * return[1,6],[8,10],[15,18].
	 */
	
	//手写
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		Comparator<Interval> comp = new Comparator<Interval>() { //【注】学习comparator的写法
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) { // start相同，则比较end
					return i1.end - i2.end;
				}
				return (i1.start - i2.start); // start不同，
			}
		};
		Collections.sort(intervals, comp);
		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= pre.end) { // pre的end在当前start的右边（即，上一个interval和当前interval有重合）
				pre.end = Math .max(pre.end, intervals.get(i).end);// 则更新pre的end为：max（上一个end，当前end）
			} else { // 上一个interval和当前interval没有重合，则将上一个interval直接加入结果集
				result.add(pre);
				pre = intervals.get(i);
			}
		}
		result.add(pre); //【注】补上最后一个
		return result;
	}
	
	//看图
	//http://blog.csdn.net/linhuanmars/article/details/21857617
	public List<Interval> merge2(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		Comparator<Interval> comp = new Comparator<Interval>() { //【注】学习comparator的写法
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) { // start相同，则比较end
					return i1.end - i2.end;
				}
				return (i1.start - i2.start); // start不同，
			}
		};
		Collections.sort(intervals, comp);
		result.add(intervals.get(0));//要在另一个list（result）里添加，而不要在原来的list（intervals）里操作
		for (int i = 0; i < intervals.size(); i++) {
			if (result.get(result.size() - 1).end >= intervals.get(i).start) { // 【注】上一个end在下一个start的右边（即，上一个interval和下一个interval有重合）
				result.get(result.size() - 1).end = Math .max(result.get(result.size() - 1).end, intervals.get(i).end);// 则更新上一个end为：max（上一个end，下一个end）
			} else { // 上一个interval和下一个interval没有重合，则将下一个interval直接加入结果集
				result.add(intervals.get(i));
			}
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