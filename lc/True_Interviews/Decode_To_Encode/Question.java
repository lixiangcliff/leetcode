package Decode_To_Encode;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String str = "abc3446kkkkkdeee365";
		System.out.println(q.encode(str));
	}
	
	/**
	 * http://www.glassdoor.com/Interview/Given-the-decode-function-to-implement-the-encode-function-abckkkkkde-and-gt-abc5xkde-For-some-case-abc3kkkkkde-both-enc-QTN_881034.htm
	 *  Given the decode function, to implement the encode function
	 *  eg:
	 *  1. abckkkkkde->abc5xkde 
	 *  2. For some case: abc3kkkkkde, both encode 3 and kkkkk-> abc1x35xkde 
	 */
	
	public String encode(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if (str.length() == 1) {
			char c = str.charAt(0);
			if (isDigit(c)){
				sb.append("1x").append(c);
				return sb.toString();
			} else {
				return str;
			}
		}
		//char pre = str.charAt(0);
		
		int count = 1;
		int l = 0;
		int r = 1;
		int len = str.length();
		boolean digit = isDigit(str.charAt(l));
		while (r <= len) {
			if (r == len || str.charAt(l) != str.charAt(r)) {
				if (digit) { // 从l到r-1都是digit
					if (r == len || !isDigit(str.charAt(r))) {
						sb.append("1x").append(str.substring(l, r));
						l = r;
					}
				} else {
					if (r - l  == 1) {
						sb.append(str.charAt(l));
					} else {
						sb.append(r - l).append("x").append(str.charAt(l));
					}
					l = r;
				}
				
			}
			if (r < len) {
				digit = isDigit(str.charAt(r));
			}
			r++;
		}
		return sb.toString();
	}
	
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

}
