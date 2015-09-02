package Find_Min_Count_of_Square_Number_toMmake_Sum;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int n = 25;
		for (int i = 1; i <= n; i++) {
			System.out.println("value: " + i + "; count:" + q.minNumber(i));
		}
	}
	
	/**
	 * http://www.1point3acres.com/bbs/thread-109586-1-1.html
	 * 找出一个数由最少几个平方的和的组成
		例子：
		input： 14    output:  9 ,4 , 1  return 3 (虽然也能由1 +1 +....+1组成 但长度是14 不是最优解)
		input:   50     ouput :  25, 25 return 2
	 */
	
	//f[i]表示值为i个的数字最少需要用几个square number来表示
	public int minNumber(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			int j = 1;
			int min = Integer.MAX_VALUE;
			int pre = 0;
			while (j * j <= i) {
				pre = f[i - j * j];
				min = Math.min(min, pre);
				j++;
			}
			f[i] = min + 1;
		}
		return f[n];
	}
	
/*	public int minNumber(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			int j = 1;
			int min = Integer.MAX_VALUE;
			while (j * j <= i) {
				int cur = 1 + f[i - j * j];
				min = Math.min(min, cur);
				j++;
			}
			f[i] = min;
		}
		return f[n];
	}*/

}
