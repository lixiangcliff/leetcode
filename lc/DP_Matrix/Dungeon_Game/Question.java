package Dungeon_Game;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * https://leetcode.com/problems/dungeon-game/
	 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
	 * The dungeon consists of M x N rooms laid out in a 2D grid. 
	 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
		The knight has an initial health point represented by a positive integer. 
		If at any point his health point drops to 0 or below, he dies immediately.
		Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
		other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
		In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
		Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
		For example, given the dungeon below, 
		the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
				-2 (K)	-3	3
				-5	-10		1
				10	30	-5 (P)
		Notes:
		The knight's health has no upper bound.
		Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
	 */
	//
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
        	return -1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] res = new int[row][col]; //【注】表示带着至少多大的health量进入[i][j]（该量能保证能从[i][j]位置走到最右下角 ）
        for (int i = row - 1; i >= 0; i--) { //【注】下面分别每种情况，都要保证不管进入还是离开都要health >= 1
        	for (int j = col - 1; j >= 0; j--) {
        		if (i == row - 1 && j == col - 1) {
        			res[i][j] = dungeon[i][j] >= 0 ? 1 : - dungeon[i][j] + 1;
        		} else if (i == row - 1) {//即需满足res[i][j] + d[i][j] >= res[i][j + 1]；同时要满足res[i][j] >= 1;所以两者取交集，则res[i][j]等于两者中较大的 
        			res[i][j] = Math.max(res[i][j + 1] - dungeon[i][j], 1); 
        		} else if (j == col - 1) {
        			res[i][j] = Math.max(res[i + 1][j] - dungeon[i][j], 1);
        		} else {
        			res[i][j] = Math.max(Math.min(res[i][j + 1], res[i + 1][j]) - dungeon[i][j], 1); //res[i][j + 1] vs res[i + 1][j],即哪边需要的血少就走哪边
        		}
        	}
        }
        return res[0][0];
     }

}
