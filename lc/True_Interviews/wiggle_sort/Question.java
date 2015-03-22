package wiggle_sort;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//int[] A = {1, 2, 8, 9, 3, 5}; 
		//int[] A = {1, 2, 3, 5, 8, 9}; 
		//int[] A = {1,4,5,2,3}; 
		int[] A = {2, 1, 3}; 
		q.sortArray(A);
		for (int i : A) {
			System.out.print(i + ",");
		}
		
	}
	
	/**
	 * " 对数组排序，使得a1<=a2>=a3<=a4>=..."
	 * http://www.mitbbs.com/article_t1/JobHunting/32575573_0_1.html
	 * http://www.mitbbs.com/article_t/JobHunting/32911043.html
	 */
	public void sortArray(int[] A) {
		if (A == null || A.length <= 1) {
			return;
		}
		if (A.length == 2) {
			if (A[0] > A[1]) {
				swap(A, 0 , 1);
			}
			return;
		}
		boolean peak = true;
		for (int i = 0; i < A.length - 2; i++) {
			if (peak) {
				int idx = findMaxIndex(A, i, i + 1, i + 2);
				if (idx != i + 1) {
					swap(A, idx, i + 1);
				}
			} else {
				int idx = findMinIndex(A, i, i + 1, i + 2);
				if (idx != i + 1) {
					swap(A, idx, i + 1);
				}
			}
			peak = !peak;
		}
	}
	
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	private int findMaxIndex(int[] A, int a, int b, int c) {
		if (A[a] >= A[b] && A[a] >= A[c]) {
			return a;
		} else if (A[b] >= A[a] && A[b] >= A[c]) {
			return b;
		} else {
			return c;
		}
	}
	
	private int findMinIndex(int[] A, int a, int b, int c) {
		if (A[a] <= A[b] && A[a] <= A[c]) {
			return a;
		} else if (A[b] <= A[a] && A[b] <= A[c]) {
			return b;
		} else {
			return c;
		}
	}

}
