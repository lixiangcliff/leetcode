package Gas_Station;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int gas[] = {1,2,3,4,5};
		int cost[] = {3,4,5,1,2};
		System.out.println(q.canCompleteCircuit(gas, cost));
	}
	

	/**
	 * https://oj.leetcode.com/problems/gas-station/
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 */
	
	//http://leetcodenotes.wordpress.com/2013/11/21/leetcode-gas-station-%E8%BD%AC%E5%9C%88%E7%9A%84%E5%8A%A0%E6%B2%B9%E7%AB%99%E7%9C%8B%E8%83%BD%E4%B8%8D%E8%83%BD%E8%B5%B0%E4%B8%80%E5%9C%88/
	//http://blog.csdn.net/linhuanmars/article/details/22706553
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
    		return -1;
    	}
		int i = 0; //当前尝试的起始位置
		int j = i; //相当于runner
		int sum = 0; // 表示从当前i到当前j累积的diff和(sum跟着i走)
		int total = 0; // 表示从起点(位置0)到当前j累积的diff和(total跟着j走)
		while (j < gas.length) { // j走完一圈就无需再走，原因看图
			int diff = gas[j] - cost[j];
			sum += diff;
			if (sum < 0) { // 已经无法从第j个位置上到达第j+1个位置
				sum = 0; // 重置sum
				i = j + 1; // i从j的下一个位置开始继续尝试
			}
			total += diff; // 累积total
			j++; // 无论i变不变， j都递增1
		}
		return total >= 0 ? i : -1; // 画图理解这么返回的原因。
	}
}
