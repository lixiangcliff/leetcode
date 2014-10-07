package Longest_Palindromic_Substring;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "abcdefgfedcba";
		String s = "abba";
		System.out.println(longestPalindrome(s));
	}
	
    public static String longestPalindrome(String s) {
        if(s == null){
        	return null;
        }
        if (s.length() <= 1){
        	return s;
        }
        int len = s.length();
        String result = s.substring(0,1);
        for(int i=0;i<len-1;i++){
        	StringBuilder sb = new StringBuilder();
        	int left = i;
        	int right = i;
        	sb.append(s.charAt(i));
        	int j = i+1;
        	while(j<len && s.charAt(i)==s.charAt(j)){
        		sb.append(s.charAt(i));
        		j++;
        	}
        	left--;
        	right=j;
        	if (sb.length() > result.length()){
				result = sb.toString();
			}
        	while(left>=0 && right<=len-1){
        		if (s.charAt(left) == s.charAt(right)){
        			sb.insert(0, s.charAt(left));
        			sb.append(s.charAt(right));
        			if (sb.length() > result.length()){
        				result = sb.toString();
        			}
        		}else{
        			break;
        		}
        		left--;
        		right++;
        	}
        }
        return result;
    }

}
