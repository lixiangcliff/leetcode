package Number_of_1_Bits;

public class Question {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    // you need to treat n as an unsigned value
	//【注】>>>与>>的区别 https://leetcode.com/discuss/28216/accepted-java-solution-but-i-have-a-question-to-ask
	// >> 符号位不会被移动 ；>>> 符号位也可以被移动
    public int hammingWeight(int n) {
    	int count = 0;
        while(n != 0) {
        	if ((n & 1) == 1) {
        		count++;
        	}
        	n >>>= 1; // must use >>> instead of >>
        }
        return count;
    }

}
