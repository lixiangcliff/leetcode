package Two_Sum;

import java.util.HashMap;

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
	
	//http://blog.csdn.net/linhuanmars/article/details/19711387
    public static int[] twoSum(int[] numbers, int target) {
    	if(numbers == null || numbers.length < 2){
    		return null;
    	}
    	int[] result = new int[2];
    	//结构为：HashMap<value, index>
    	//【注】之所以不设计成<index, value>，是因为之后map只能通过key来找val，反之不行
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < numbers.length; i++){
    		//find them!
    		if(map.containsKey(target - numbers[i])){
    			//之前已经放入map的value为target - numbers[i]
    			result[0] = map.get(target - numbers[i])+1; //通过value作为map中的key，找map中的value也就是index
    			result[1] = i+1;
    			return result;
    		}
    		map.put(numbers[i], i);
    	}
        return null;
    }

}
