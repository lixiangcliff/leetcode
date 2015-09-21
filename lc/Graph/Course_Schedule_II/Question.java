package Course_Schedule_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int numCourses = 2;
		int [][] prerequisites = {
				{1, 0},
				{0, 1},
		};
		
		int[] res = q.findOrder(numCourses, prerequisites);
		if (res.length != 0) {
			for (int num : res) {
				System.out.print(num + ",");
			}
		} else {
			System.out.println("nothing!");
		}
		
		
	}
	
	/**
	 * https://leetcode.com/problems/course-schedule-ii/
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
		Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
		Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
		There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
		
		For example:
		2, [[1,0]]
		There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
		
		4, [[1,0],[2,0],[3,1],[3,2]]
		There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
		
		Note:
		The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
		
		Hints:
		This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
		Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
		Topological sort could also be done via BFS.
	 */
	
	//similar to Course_Schedule
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] empty = {}; // 【注】 {}表示一个空数组
    	if (numCourses <= 0 || prerequisites == null) {
    		return empty;
    	}
    	HashMap<Integer, Integer> inDegreeMap = new HashMap<Integer, Integer>(); // <course #, 该course入度（即该course的所有prerequisite（上游）的个数）>
    	HashMap<Integer, ArrayList<Integer>> nbrMap = new HashMap<Integer, ArrayList<Integer>>(); // <course #, 该course的所有下游course>
    	//统计每个node的入度
    	for (int i = 0; i < prerequisites.length; i++) {
    		if (prerequisites[i][0] < 0 || prerequisites[i][0] >= numCourses || prerequisites[i][1] < 0 || prerequisites[i][1] >= numCourses) {
    			return empty;
    		}
    		int cur = prerequisites[i][1]; // 上游node
    		int next = prerequisites[i][0]; // 一个node作为“下游” 出现的次数
    		if (inDegreeMap.containsKey(next)) {
    			inDegreeMap.put(next, inDegreeMap.get(next) + 1);
    		} else {
    			inDegreeMap.put(next, 1);
    		}
    		if (nbrMap.containsKey(cur)) {
    			nbrMap.get(cur).add(next);
    		} else {
    			ArrayList<Integer> nbrs = new ArrayList<Integer>();
    			nbrs.add(next);
    			nbrMap.put(cur, nbrs);
    		}
    	}
    	int pos = 0;
    	int[] res = new int[numCourses];
    	LinkedList<Integer> q = new LinkedList<Integer>();
    	int zeroInDegreeCount = 0;
    	for (int i = 0; i < numCourses; i++) { //遍历所有课程
    		if (!inDegreeMap.containsKey(i)) {
    			q.add(i);
    			res[pos++] = i;
    			zeroInDegreeCount++;
    		}
    	}
    	while (!q.isEmpty()) {
    		int cur = q.poll(); // 入度为0的node
    		if (nbrMap.containsKey(cur)) {
	    		for (int next : nbrMap.get(cur)) {
	    			inDegreeMap.put(next, inDegreeMap.get(next) - 1);
					if (inDegreeMap.get(next) == 0) {
						q.add(next);
						res[pos++] = next;
						zeroInDegreeCount++;
					}
	    		}
    		}
    	}
    	if (zeroInDegreeCount == numCourses) {
    		return res;
    	} else {
    		return empty;
    	}
    }

}
