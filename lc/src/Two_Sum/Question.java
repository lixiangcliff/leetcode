package Two_Sum;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers={0,2,4,0};
		int[] result = twoSum(numbers,0);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
    public static int[] twoSum(int[] numbers, int target) {
    	if(numbers == null || numbers.length < 2){
    		return null;
    	}
    	int[] sortedNumbers = numbers.clone();
    	Arrays.sort(sortedNumbers);
        int[] result = new int[2];
        for(int i=0; i<sortedNumbers.length-1;i++){
        	int rest = target - sortedNumbers[i];
        	int left = i+1;
        	int right = sortedNumbers.length -1;
        	while(left<=right){
        		int mid = (left+right)/2;
        		if(sortedNumbers[mid] == rest){
        			boolean firstDone = false;
        			for(int j=0;j<numbers.length;j++){
        				if (!firstDone && (numbers[j] == sortedNumbers[i] || numbers[j] == sortedNumbers[mid])){
        					result[0] = j+1;
        					firstDone = true;
        					continue;
        				}
        				if (firstDone && (numbers[j] == sortedNumbers[i] || numbers[j] == sortedNumbers[mid])){
        					result[1] = j+1;
        					return result;
        				}
        				
        			}
        		}
        		if(sortedNumbers[mid] < rest){
        			left = mid+1;
        		}
        		if(sortedNumbers[mid] > rest){
        			right = mid-1;
        		}
        	}
        }
        return result;
    }

}
