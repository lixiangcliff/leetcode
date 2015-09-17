package Meeting_Rooms;

import java.util.Arrays;
import java.util.Comparator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		Interval i1 = new Interval(0, 6);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = {i1, i2, i3};
		System.out.println(q.canAttendMeetings(intervals));
	}

	/**
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
	 * determine if a person could attend all meetings.

		For example,
		
		Given [[0, 30],[5, 10],[15, 20]],
		return false
	 */
	
	//http://sbzhouhao.net/LeetCode/LeetCode-Meeting-Rooms.html
	 public boolean canAttendMeetings(Interval[] intervals) {
		 Comparator<Interval> comp = new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) {
					return i1.end - i2.end;
				} else {
					return i1.start - i2.start;
				}
			}
		 };
		 Arrays.sort(intervals, comp);
		 for (int i = 1; i < intervals.length; i++) {
			 if (intervals[i].start < intervals[i - 1].end) {
				 return false;
			 }
		 }
		 return true;
	 }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
