package Longest_Common_Prefix;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {
				"abcdefg",
				"abcdefg",
				"abcdefg",
				"abcdefgh",
				
		};
/*		String[] strs = {
				"a",
				"a",
				"a",
							
		};*/
/*		String[] strs = {
				""
				
		};*/
		System.out.print(longestCommonPrefix(strs));

	}
	
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
        	return "";
        }
        
        boolean terminated = false;
        int len = 0;
        char ref;
        while(!terminated){
        	if(len>=strs[0].length()){ // reach the end of first str;
        		break;
        	}else{
        		ref = strs[0].charAt(len);
        	}
        	for(int i=1;i<strs.length;i++){
        		if(len >=strs[i].length() || strs[i].charAt(len) != ref){
        			terminated = true;
        			break;
        		}
        	}
        	if (!terminated){
        		len++;
        	}       	
        }
        
        return strs[0].substring(0,len);
    }    

}
