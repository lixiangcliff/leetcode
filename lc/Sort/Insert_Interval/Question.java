package Insert_Interval;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//看图！
	//http://blog.csdn.net/linhuanmars/article/details/22238433
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	int size = intervals.size();
    	if(intervals == null || size == 0){
    		result.add(newInterval);
    		return result;
    	}
    	int i=0;
        //只要interval.end < newInterval.start；即newInterval和interval【注】没有【注】overlap
        while (i < size && intervals.get(i).end < newInterval.start) {
        	result.add(intervals.get(i));
        	i++;
        }
        if (i<size){
        	//确定最终的newInterval.start为: min(newInterval.start, intervals.start)
        	newInterval.start = Math.min(newInterval.start, intervals.get(i).start); 
        }
        //只要interval.start <= newInterval.end；即newInterval和interval【注】仍有【注】overlap
        while(i<size && intervals.get(i).start <= newInterval.end){//compare new's end and array's start
        	//每次更新newInterval.right为最新的: max(newInterval.end, intervals.end)。
        	newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        	i++;
        }
        result.add(newInterval);//处理完newInterval的所有overlap，把newInterval加入结果集
        //把原来list里的interval都加到结果集
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