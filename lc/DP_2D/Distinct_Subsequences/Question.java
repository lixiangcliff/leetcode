package Distinct_Subsequences;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "rabbbit";
		String T = "rabbit";
		System.out.print(numDistinct(S,T));
	}
	
	
	//two dimension DP: http://blog.csdn.net/abcbc/article/details/8978146 
	//one dimension DP: http://blog.csdn.net/linhuanmars/article/details/23589057
	/*
	 * example:
					S(j) index
				    0 1 2 3 4 5 6 7
				      r a b b b i t
		T(i)	0   1 1 1 1 1 1 1 1
		index	1 r 0 1 1 1 1 1 1 1
				2 a 0 0 1 1 1 1 1 1
				3 b 0 0 0 1 2 3 3 3
				4 b 0 0 0 0 1 3 3 3
				5 i 0 0 0 0 0 0 3 3
				6 t 0 0 0 0 0 0 0 3 
				
				result[][]
	 */
    public static int numDistinct(String S, String T) {
    	int sLen = S.length();
    	int tLen = T.length();
        if (sLen == 0){
        	return 0;
        }
        if (tLen == 0){
        	return 1;
        }
        int[][] result = new int[tLen+1][sLen+1];
        Arrays.fill(result[0], 1);
        for(int i=1;i<tLen+1;i++){
        	result[i][0] = 0;
        }
        for(int i=1; i<tLen+1;i++){
        	for(int j=1;j<sLen+1;j++){
        		//if: T.charAt(i-1) != S.charAt(j-1)
        		//then: result[i][j] == result[i][j-1]; 
        		//because adding S.charAt(j-1) will not make more subsequence
        		//
        		//if: T.charAt(i-1) == S.charAt(j-1)
        		//then: result[i][j] == result[i][j-1] + result[i-1][j-1];
        		//because all valid subsequence in result[i][j-1] still count;
        		//meanwhile all valid subsequence in result[i-1][j-1] will be still valid(after adding same char at the end) 
        		result[i][j] = result[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? result[i-1][j-1] : 0);
        	}
        }
        return result[tLen][sLen];
    }

}
