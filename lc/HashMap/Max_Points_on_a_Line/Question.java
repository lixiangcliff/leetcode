package Max_Points_on_a_Line;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/max-points-on-a-line/
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/21060933
	//用HashMap, time: O(n^2); space O(n)
	public int maxPoints(Point[] points) {
		if (points == null || points.length <= 0) {
			return 0;
		}
		int max = 1; // 【注】初始值为1.因为至少两个点，且两点可以确定一条直线。
		for (int i = 0; i < points.length - 1; i++) { // 【注】i < points.length-1是因为j从i + 1起始，到 points.length-1为止，要防止j越界
			HashMap<Double, Integer> map = new HashMap<Double, Integer>(); //<ratio(斜率), 与当前点i构成斜率为ratio的点的个数>。每个i都需要一个新的map
			int numOfSame = 0;// 有多少点和当前点位置重复
			int curMax = 1;
			for (int j = i + 1; j < points.length; j++) {
				double ratio = 0.0;
				// 判断j点是否和i点重复；如不重复，则求j和i的斜率（求ratio是要特殊考虑x和y等于0时的情况）
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					numOfSame++;
					continue;
				} else if (points[i].x == points[j].x) {
					ratio = (double) Integer.MAX_VALUE;
				} else if (points[i].y == points[j].y) {
					ratio = 0.0;
				} else {
					ratio = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
				}
				if (map.containsKey(ratio)) { // 看ratio是否已经在map里
					map.put(ratio, map.get(ratio) + 1);
				} else {
					map.put(ratio, 2); //【注】此处点的个数为2，而不是1。因为一条直线需要两个点。
				}
				curMax = Math.max(curMax, map.get(ratio));
			}
			max = Math.max(max, curMax + numOfSame); // 更新max（ 如果有和i重复的点，也要计算上（因为ratio可以理解为相同））
		}
		return max;
	}
}

class Point {
	int x;
	int y;
	Point() {
		x = 0;
		y = 0;
	}
	Point(int a, int b) {
		x = a;
		y = b;
	}
}
