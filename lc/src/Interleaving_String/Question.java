package Interleaving_String;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
/*		String s1 = "abc";
		String s2 = "def";
		String s3 = "abcdef";*/
		//String s3 = "aadbbbaccc";
		
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24683159
	//2d dp
	//best way to deal with index, is to draw a matrix table!
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
        	return false;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        boolean[][] result = new boolean[s1Len+1][s2Len+1]; 
        result[0][0] = true;
        for(int i=0; i<s2Len; i++){
        	result[0][i+1] = result[0][i] && s2.charAt(i)==s3.charAt(i);
        }
        for(int i=0; i<s1Len; i++){
        	result[i+1][0] =  result[i][0] && s1.charAt(i)==s3.charAt(i); 
        }
        for(int i=0; i<s1Len; i++){
        	for(int j=0; j<s2Len;j++){
        		//make some simple example like s1 = {a,b,c}; s2 = {d,e}, s3 = {a,b,c,d,e} 
        		//draw the matrix and e.g when i=1 j=2, to deduct below formula
        		result[i+1][j+1] = result[i+1][j]&&s2.charAt(j)==s3.charAt(i+j+1) || result[i][j+1] && s1.charAt(i)==s3.charAt(i+j+1);
        	}
        }
        return result[s1Len][s2Len];
    }

}
