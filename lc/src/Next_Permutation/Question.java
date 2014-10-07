package Next_Permutation;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3,2,1};
		nextPermutation(num);
		for(int i=0;i<num.length;i++){
			System.out.print(num[i] + ",");
		}
	}
	
    public static void nextPermutation(int[] num) {
        if(num == null || num.length==0 || num.length==1){
        	return;
        }
        int len = num.length;
        for(int i = len-1; i>0;i--){
        	if(num[i-1]<num[i]){
        		int j = len-1;
        		while(j>=i){
        			if(num[j]>num[i-1]){
        				break;
        			}
        			j--;
        		}
        		int temp = num[i-1];
        		num[i-1] = num[j];
        		num[j] =  temp;
        		Arrays.sort(num, i, len);
        		return;
        	}
        }
        Arrays.sort(num, 0, len);
        return;
    }

}
