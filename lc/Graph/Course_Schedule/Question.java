package Course_Schedule;

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
		};
		System.out.println(q.canFinish(numCourses, prerequisites));

	}
	
	/**
	 * https://leetcode.com/problems/course-schedule/
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
		Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
		Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
		
		For example:
		
		2, [[1,0]]
		There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
		
		2, [[1,0],[0,1]]
		There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
		
		Note:
		The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
		
		click to show more hints.
		
		Hints:
		This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
		Topological Sort via DFS( https://class.coursera.org/algo-003/lecture/52 ) - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
		Topological sort could also be done via BFS.
	 */
	
	//http://www.meetqun.com/thread-9123-1-4.html
	//http://www.meetqun.com/thread-9208-1-1.html
	//check whether there is circle. similar to "Topological_Sorting" in lintcode
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // <course #, 该course入度（即该course的所有prerequisite（上游）的个数）>
    	//统计每个node的入度
    	for (int i = 0; i < prerequisites.length; i++) {
    		if (prerequisites[i][0] < 0 || prerequisites[i][0] >= numCourses || prerequisites[i][1] < 0 || prerequisites[i][1] >= numCourses) {
    			return false;
    		}
    		int key = prerequisites[i][0]; // 一个node作为“下游” 出现的次数
    		if (map.containsKey(key)) { // 【注】将入度>0的course都放入map
    			map.put(key, map.get(key) + 1);
    		} else {
    			map.put(key, 1);
    		}
    	}
    	if (map.size() == numCourses) { //没有任何一个course入度为0
    		return false;
    	}
    	LinkedList<Integer> q = new LinkedList<Integer>(); // 但凡bfs遍历图，都要用到queue
    	int zeroInDegreeCount = 0;
    	for (int i = 0; i < numCourses; i++) { //遍历所有课程，把所有入度为0的，加入queue
    		if (!map.containsKey(i)) {
    			q.add(i);
    			zeroInDegreeCount++;
    		}
    	}
    	while (!q.isEmpty()) {
    		int key = q.poll();
    		for (int i = 0; i < prerequisites.length; i++) { //如果事先把当前key的所有next都存入一个数组，就可以省去这次遍历。参考Course_Schedule_II
    			if (prerequisites[i][1] == key) {
    				int next = prerequisites[i][0]; //得到key的“下游”--next
    				map.put(next, map.get(next) - 1);
    				if (map.get(next) == 0) {
    					q.add(next);
    					//map.remove(next); //这样做也可以，但是cost太大
    					zeroInDegreeCount++;
    				}
    			}
    		}
    	}
        return zeroInDegreeCount == numCourses;
    	//return map.size() == 0; //这样做也可以，但是cost太大
    }

}
