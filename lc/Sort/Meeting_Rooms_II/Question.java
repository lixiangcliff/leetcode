package Meeting_Rooms_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
/*		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(3, 8);
		Interval i3 = new Interval(4, 14);
		Interval i4 = new Interval(8, 11);
		Interval[] intervals = {i1, i2, i3, i4};*/
		Interval i1 = new Interval(0, 5);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(10, 20);
		Interval[] intervals = {i1, i2, i3};
		System.out.println(q.minMeetingRooms(intervals));

	}
	
	/**
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
	 * find the minimum number of conference rooms required.
	 * For example,
		Given [[0, 30],[5, 10],[15, 20]],
		return 2.
	 */

	//http://likesky3.iteye.com/blog/2235665
	/*
	 * Very similar with what we do in real life. Whenever you want to start a meeting, 
	 * you go and check if any empty room available (available > 0) and 
	 * if so take one of them ( available -=1 ). Otherwise, 
	 * you need to find a new room someplace else ( numRooms += 1 ).  
	 * After you finish the meeting, the room becomes available again ( available += 1 ). 
	 */
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		ArrayList<Point> points = new ArrayList<Point>();
		Comparator<Point> comp = new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.val == p2.val) {
					if (p1.isStart) {
						return 1;
					} else {
						return -1; //值相同的node，end在前，start在后
					}
				} else {
					return p1.val - p2.val;
				}
			}
		};
		for (Interval it : intervals) {
			points.add(new Point(it.start, true));
			points.add(new Point(it.end, false));
		}
		Collections.sort(points, comp);
		int min = 0;
		int count = 0;
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i).isStart) {
				count++;
			} else {
				count--;
			}
			min = Math.max(min, count);
		}
		return min;
	}
}

class Point {
	int val;
	boolean isStart;
	Point (int val, boolean isStart){
		this.val = val;
		this.isStart = isStart;
	}
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
