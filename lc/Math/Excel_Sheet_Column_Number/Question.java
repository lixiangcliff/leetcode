package Excel_Sheet_Column_Number;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.titleToNumber("CFDGSXM"));
	}
	
	/**
	 * https://leetcode.com/problems/excel-sheet-column-number/
	 * Related to question Excel Sheet Column Title
		Given a column title as appear in an Excel sheet, return its corresponding column number.
		For example:
		
		    A -> 1
		    B -> 2
		    C -> 3
		    ...
		    Z -> 26
		    AA -> 27
		    AB -> 28 
	 */
		
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
        	return -1;
        }
        int base = 1;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	char cur = s.charAt(i);
        	if (cur < 'A' || cur > 'Z') {
        		return -1;
        	}
        	int val = cur - 'A' + 1;
        	if (val <= (Integer.MAX_VALUE - res) / base) {
        		res += val * base;
        	} else {
        		return -1;
        	}
        	if (base <= Integer.MAX_VALUE / 26) { 
        		base *= 26;
        	} else if (i != 0) { // 如果i == 0，即使这一轮base * 26越界，对最终结果也不会有影响了。
        		return -1;
        	}
        }
        return res;
    }

}
