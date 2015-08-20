package Fibonacci;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://stackoverflow.com/questions/8532142/iterative-and-recursive-version-has-same-complexity
	
	int iterative_fib(int n) {
		   if (n <= 2) {
		     return 1;
		   }
		   int a = 1;
		   int b = 1;
		   int c = 0;
		   for (int i = 0; i < n - 2; ++i) {
		     c = a + b;
		     a = b;
		     b = c;
		   }
		   return c;
		}

	int recursive_fib(int n) {
		if (n <= 2) {
			return 1;
		}
		return recursive_fib(n - 1) + recursive_fib(n - 2);
	}
	
	//recursive memorized
	public int solve(int n, int[] mem) {
		if (n <= 2) {
			return mem[n] = 1;
		}
		if (mem[n - 1] == 0) {
			solve(n - 1, mem);
		}
/*		if (mem[n - 2] == 0) {
			solve(n - 2, mem);
		}*/
		return mem[n] = mem[n - 1] + mem[n - 2];
	}

}
