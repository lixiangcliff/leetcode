package Merge_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21857617
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	if(intervals == null || intervals.size()==0){
    		return result;
    	}
    	Comparator<Interval> comp = new Comparator<Interval>(){
    		//@Override
    		public int compare(Interval i1, Interval i2){
    			if(i1.start == i2.start){
    				return i1.end - i2.end;
    			}
    			return(i1.start - i2.start);
    		}
    	};
    	Collections.sort(intervals, comp);
    	result.add(intervals.get(0));
    	for(int i=0;i<intervals.size();i++){
    		if(result.get(result.size()-1).end >= intervals.get(i).start){
    			if (result.get(result.size()-1).end < intervals.get(i).end){
    				result.get(result.size()-1).end = intervals.get(i).end;
    			}
    		}else{
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