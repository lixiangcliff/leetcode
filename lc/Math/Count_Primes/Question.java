package Count_Primes;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int n = 10;
		System.out.print(q.countPrimes(10000));
	}
	
	/**
	 * 
	 * Count the number of prime numbers less than a non-negative number, n
	 */
	
	//http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	//不包括n
    public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}
		boolean[] isComp = new boolean[n + 1];
		isComp[0] = true;
		isComp[1] = true;
		int cur = 2;
		while ((double) cur < (double) n / cur) {
			int times = 2;
			while ((double) cur <= (double) n / times) {
				isComp[cur * times] = true;
				times++;
			}
			cur++;
			while (cur < n / cur && isComp[cur]) {
				cur++;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!isComp[i]) {
				count++;
			}
		}
		return count;
    }

}
