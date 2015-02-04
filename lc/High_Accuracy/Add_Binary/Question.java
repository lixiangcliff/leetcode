package Add_Binary;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.addBinary("11","1"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/add-binary/
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, 
	 * a = "11" 
	 * b = "1" 
	 * Return "100".
	 */
	
	//从低位开始相加，一直维护进位，一直append，最后反转，勿忘最后一次的可能进位。
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}
		int m = a.length();
		int n = b.length();
		int k = Math.max(m, n); // 选长度更长的那个作为相加循环的次数
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			int aValue = i < m ? (int) (a.charAt(m - 1 - i) - '0') : 0; // 只要还有没处理的位，就得到该位的值，否则直接置0
			int bValue = i < n ? (int) (b.charAt(n - 1 - i) - '0') : 0; // 从后往前来相加。边界要举例。
			int value = aValue + bValue + carry;
			int digit = value % 2; // 得到加和在本位的值
			carry = value / 2; // 进位值
			sb.append(digit);
		}
		if (carry == 1) { // 【注】说明加和比最长的那个数还要多1位
			sb.append(1);
		}
		return sb.reverse().toString(); // 之所以用append最后reverse，而不是一直insert(0), 是因为insert太costly
	}
}
