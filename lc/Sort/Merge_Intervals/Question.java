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
	
	//看图
	//http://blog.csdn.net/linhuanmars/article/details/21857617
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	if(intervals == null || intervals.size()==0){
    		return result;
    	}
    	Comparator<Interval> comp = new Comparator<Interval>(){
    		//@Override
    		public int compare(Interval i1, Interval i2){
    			if(i1.start == i2.start){ //start相同，则比较end
    				return i1.end - i2.end;
    			}
    			return(i1.start - i2.start); //start不同，
    		}
    	};
    	Collections.sort(intervals, comp);
    	result.add(intervals.get(0));
    	for(int i=0;i<intervals.size();i++){
    		//【注】看图！
    		if(result.get(result.size()-1).end >= intervals.get(i).start){ //上一个end在下一个start的右边（即，上一个interval和下一个interval有重合）
    			result.get(result.size()-1).end = Math.max(result.get(result.size()-1).end, intervals.get(i).end);//则更新上一个end为：max（上一个end，下一个end）
    		}else{ //上一个interval和下一个interval没有重合，则讲下一个interval直接加入结果集
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