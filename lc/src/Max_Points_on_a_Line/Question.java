package Max_Points_on_a_Line;

import java.awt.Point;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21060933
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
        	return 0;
        }
        if (allSamePoint(points)){
        	return points.length;
        }
        int max = 0;
        for(int i=0;i<points.length-1;i++){
        	for(int j=1;j<points.length;j++){
        		//i and j are same points
        		if(points[i].x == points[j].x && points[i].y == points[j].y){
        			continue;
        		}
        		int cur =2;
        		//why k starts from 0 not j+1;
        		for (int k=0;k<points.length;k++){
        			if(k!=i && k!=j && (points[i].y - points[j].y)*(points[k].x -points[j].x)==(points[i].x -points[j].x)*(points[k].y - points[j].y)){
        				cur++;
        			}
        		}
        		max = Math.max(cur, max);
        	}
        }
        return max;
    }
    
    private boolean allSamePoint(Point[] points){
    	for(int i=1;i<points.length;i++){
    		//if(points[0].x == points[i].x && points[0].y == points[i].y){
    		if(points[0].x != points[i].x || points[0].y != points[i].y){
    			return false;
    		}
    	}
    	return true;
    }
    

}
