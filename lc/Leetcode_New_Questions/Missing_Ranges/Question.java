package Missing_Ranges;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int vals[] = {0, 1, 3, 50, 75};
		List<String> result = q.findMissingRanges(vals, 0,99);
		for (String s : result) {
			System.out.print(s + ",");
			System.out.println("");
		}
	}
	
	/**
	 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its
		missing ranges.
		For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
	 */

	//技巧：补一个dummy pre和一个dummy cur
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> res = new ArrayList<String>();
		int pre = start - 1; // 表示当前缺失范围的前一个index
		for (int i = 0; i <= vals.length; i++) {
			int cur = (i == vals.length) ? end + 1 : vals[i]; //cur表示当前缺失范围的下一个index【注】cur的计算方法
			if (cur - pre >= 2) {
				res.add(getRange(pre + 1, cur - 1));
			}
			pre = cur;
		}
		return res;
	}
	
	private String getRange(int l, int r) {
		return l == r ? String.valueOf(l) : String.valueOf(l + "->" + r);
	}
	
}
