package Count_Primes;

import java.util.ArrayList;

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
	 * https://leetcode.com/problems/count-primes/
	 * Count the number of prime numbers less than a non-negative number, n
	 */
    public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}
		boolean[] isComp = new boolean[n + 1];
		isComp[0] = true;
		isComp[1] = true;
		int cur = 2; // cur表示当前一轮的prime
		while (cur <= n / cur) { // 用除法防止越界
			int times = 2;
			while (cur <= n / times) {
				isComp[cur * times] = true;
				times++;
			}
			cur++;
			while (cur < n / cur && isComp[cur]) { //【注】只用prime来除
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
    
	//手写 input == 499979时候会超时
	public int countPrimes2(int n) {
		if (n < 3) {
			return 0;
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i < n; i++) {
			boolean isPrime = true;
			for (int prime : primes) {
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		return primes.size();
    }
	
	//http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	//不包括n


}
