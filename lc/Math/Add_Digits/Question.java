package Add_Digits;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
		For example:
		Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
		Follow up:
		Could you do it without any loop/recursion in O(1) runtime?
	 */
	
	//可以举例找规律，比如打印出前30个数字的结果 http://bookshadow.com/weblog/2015/08/16/leetcode-add-digits/
	/*
	 * https://leetcode.com/discuss/55910/two-lines-c-code-with-explanation
	 * The essence of this problem is that 10^n ≡ 1 (mod 9), and thus an*10^n + ... + a1*10 + a_0 ≡ a_n + ... + a_1 + a_0 (mod 9). 
	 * This process can be continued until a number less than 9 is gotten, i.e. num % 9. For any digit n, n = n % 9 unless n = 9. 
	 * The only confusing case is n % 9 = 0, but addDigits(num) = 0 if and only if num = 0, otherwise it should be 9 in fact.
	 */
	//https://leetcode.com/discuss/55267/three-lines-c-solution-w-o-loop-recursion
	public int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 9 == 0) {
			return 9;
		}
		return num % 9;
	}
	
	//naive way
    public int addDigits2(int num) {
        if (num < 0) {
        	return -1;
        }
        while (num > 9) {
        	int sum = 0;
        	while (num > 0) {
            	sum += num % 10;
            	num /= 10;
        	}
        	num = sum;
        }
        return num;
    }

}
