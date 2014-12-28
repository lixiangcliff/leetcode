package Two_Sum_II__Input_array_is_sorted;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Question: 
	 * Similar to Question [1. Two Sum], except that the input array
	 * is already sorted in ascending order.
	 */
	
	/*
	 * Solution: 
	 * Of course we could still apply the [Hash table] approach, but
	 * it costs us O(n) extra space, plus it does not make use of the fact that
	 * the input is already sorted. 
	 */
	
	/* 
	 * O(n log n) runtime, O(1) space – Binary search: 
	 * For each element x, we could look up if target – x exists in
	 * O(log n) time by applying binary search over the sorted array. Total
	 * runtime complexity is O(n log n). 
	 *
	 */
	public int[] twoSum(int[] numbers, int target) {
		// Assume input is already sorted.
		for (int i = 0; i < numbers.length; i++) {
			int j = bsearch(numbers, target - numbers[i], i + 1);
			if (j != -1) {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private int bsearch(int[] A, int key, int start) {
		int L = start, R = A.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (A[M] < key) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (L == R && A[L] == key) ? L : -1;
	}
	
	/* 
	 * O(n) runtime, O(1) space – Two pointers: 
	 * Let’s assume we have two indices pointing to
	 * the i th and j th elements, Ai and Aj respectively. The sum of Ai and Aj
	 * could only fall into one of these three possibilities: 
	 * 
	 * 	i. Ai + Aj > target. Increasing i isn’t going to help us, as it makes the sum even
	 * 						bigger. Therefore we should decrement j. 
	 * 	ii. Ai + Aj < target. Decreasing j isn’t going to help us, 
	 * 						as it makes the sum even smaller. Therefore we should increment i. 
	 *  iii. Ai + Aj == target. We have found the answer.
	 */
	
	public int[] twoSum2(int[] numbers, int target) {
		// Assume input is already sorted.
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
