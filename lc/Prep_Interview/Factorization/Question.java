package Factorization;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<Integer> res = q.factor(1234);
        for(int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }

		
	}
	
	//http://bbs.bccn.net/thread-339401-1-1.html
	ArrayList<Integer> factor(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n <= 1) {
			return res;
		}
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				res.add(i);
				n /= i;
			}
		}
		return res;
	}
	
	
/*	public void factor(int num) {
		int i;
		boolean flag = false;
		for (i = 2; i <= num; i++) {
			if (flag == true) {
				System.out.print("*");
				flag = false;
			}
			if (num % i == 0) {
				System.out.print(i);
				flag = true;
				num = num / i;
				while (num % i == 0) {
					num = num / i;
					if (flag == true) {
						System.out.print("*");
						flag = false;
					}
					System.out.print(i);
					flag = true;
				}
			}

		}

	}*/

}
