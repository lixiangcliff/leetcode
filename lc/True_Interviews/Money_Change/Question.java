package Money_Change;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * http://www.mitbbs.com/article_t/JobHunting/32869937.html
	 * An atm can only dispense values of $1, $5, $20, and $50. Return the number 
		of unique ways that a $ amount of X can be tendered.
		($1, $5) is distinct from ($5, $1)
		
		Input: 4 Output: 1
		Input: 6 Output: 3
	 */
	
	//DP
	public int moneyChange(int n) {
		if (n < 0) {
			return -1;
		}
		int[] res = new int[n + 1]; // how many method when n dollars
		res[0] = 1;
		for (int i = 1; i <= n ; i++) {
			res[i] = res[i - 1];
			if (i >= 5) {
				res[i] += res[i - 5]; //为什么用加法？
			}
		}
		return res[n];
	}
	

}
