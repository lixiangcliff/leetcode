package Max_Points_on_a_Line;

import java.awt.Point;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21060933
	//用HashMap, time: O(n^2); space O(n)
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
        	return 0;
        }
        int max = 1; //【注】初始值为1!
        for (int i = 0; i < points.length-1; i++){//i < points.length-1是因为j=i+1起始，要防止j越界
        	//HashMap<ratio(斜率), 与当前点i构成斜率为ratio的点的个数>
        	HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        	int numOfSame = 0;//有多少点和当前点位置重复
        	double ratio = 0.0;
        	int localMax = 1; //【注】初始值为1!
        	for(int j = i+1; j < points.length; j++){
        		//判断j点是否和i点重复；如不重复求j和i的斜率
        		if(points[i].x == points[j].x && points[i].y == points[j].y){
        			numOfSame++;
        			continue;
        		}else if (points[i].x == points[j].x){
        			ratio = (double)Integer.MAX_VALUE;
        		}else if (points[i].y == points[j].y){
        			ratio = 0.0;
        		}else{
        			ratio = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
        		}
        		//看ratio是否已经在map里
        		if(map.containsKey(ratio)){
        			map.put(ratio, map.get(ratio)+1);
        		}else{
        			map.put(ratio, 2);
        		}
        	}
        	//完成了对当前点i，所有与之构成直线ratio的统计，取其中value最大的作为localMax
        	for (Integer value : map.values()){
        		localMax = Math.max(value, localMax);
        	}
        	//如果有和i重复的点，也要计算上（因为ratio可以理解为相同）
        	localMax += numOfSame;
        	//确定了当前i的localMax，现在更新max
        	max = Math.max(localMax, max);
        }
        return max;
    }
}
