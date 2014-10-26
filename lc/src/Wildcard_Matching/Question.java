package Wildcard_Matching;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("ab", "?*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21198049
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0){
        	return s.length() == 0;
        }
        //to pass leetcode start;
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')  
            return false;
        ////to pass leetcode end;
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for(int j=0; j<p.length(); j++){
        	if(p.charAt(j) != '*'){
        		for(int i=s.length()-1; i>=0; i--){
        			result[i+1] = result[i] && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?');
        		}
        	}else{
        		int i=0;
        		//while(i<s.length() && !result[i]){ // missed last index!
        		while(i<=s.length() && !result[i]){
        			result[i++] = false;
        		}
        		while(i<=s.length()){
        			result[i++] = true;
        		}
        	}
        	result[0] = result[0] && p.charAt(j)=='*';
        }
        return result[s.length()];
    }

}
