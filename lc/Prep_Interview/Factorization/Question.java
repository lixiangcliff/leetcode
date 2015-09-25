package Factorization;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		q.factor(100);
        /*for(int i = 0; i < f.length; i++) {
            System.out.print(f[i] + " ");
        }
        System.out.println();*/
	}
	
	//http://bbs.bccn.net/thread-339401-1-1.html
	public void factor(int num) {
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

	}

}
