package Ternay_Format_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.ternay(4280412));
	}
	
	/**
	 * http://www.glassdoor.com/Interview/How-to-find-ternay-representation-of-a-number-FInd-minimum-spanning-tree-QTN_884257.htm
	 * How to find ternay(三进制) representation of a number 
	 */
	
	//for testing: http://www.cleavebooks.co.uk/scol/calnumba.htm
	public String ternay(int x) {
		boolean negative = false;
		if (x < 0) {
			negative = true;
			if (x == Integer.MIN_VALUE) {
				return "";
			} else {
				x = -x;
			}
		}
		int base = 1;
		while (base <= x / 3) {
			base *= 3;
		}
		StringBuilder sb = new StringBuilder();
		while (base > 0) {
			sb.append(x / base);
			x %= base;
			base /= 3;
		}
		if (negative) {
			sb.insert(0, "-");
		}
		return sb.toString();
	}
	

}
