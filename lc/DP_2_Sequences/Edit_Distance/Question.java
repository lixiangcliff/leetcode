package Edit_Distance;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//need to chew it again
	//http://blog.csdn.net/linhuanmars/article/details/24213795
	//http://huntfor.iteye.com/blog/2077940
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0){
        	return len2;
        }
        if(len2 == 0){
        	return len1;
        }
        int minLen = Math.min(len1, len2);
        int maxLen = Math.max(len1, len2);
        String minWord = len2 > len1 ? word1 : word2;
        String maxWord = len2 > len1 ? word2 : word1;
        int[] result = new int[minLen + 1];
        //initialize result array;
        for(int i=0; i< result.length;i++){
        	result[i] = i;
        }
        for(int i=0;i<maxLen;i++){
        	int[] newResult = new int[minLen+1];
        	newResult[0] = i+1;//why not =i?..
        	for (int j=0;j<minLen;j++){
        		if(maxWord.charAt(i) == minWord.charAt(j)){
        			newResult[j+1] = result[j];
        		}else{
        			newResult[j+1] = Math.min(result[j+1], Math.min(result[j], newResult[j])) +1;
        		}
        	}
        	result = newResult;
        }
        return result[minLen];
    }
    

}
