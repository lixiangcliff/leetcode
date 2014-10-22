package Insert_Interval;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22238433
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	int size = intervals.size();
    	if(intervals == null || size == 0){
    		result.add(newInterval);
    		return result;
    	}
    	int i=0;
        for(; i<size; i++){
        	if (intervals.get(i).end<newInterval.start){ //compare new's start and array's end
        		result.add(intervals.get(i));
        	}else{
        		break;
        	}
        }
        if (i<size){
        	//final new's start is leftmost one between new's start and array's start
        	newInterval.start = Math.min(newInterval.start, intervals.get(i).start); 
        }
        while(i<size && intervals.get(i).start <= newInterval.end){//compare new's end and array's start
        	//final new's end is rightmost one between new's end and array's end
        	newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        	i++;
        }
        result.add(newInterval);
        while(i<size){
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