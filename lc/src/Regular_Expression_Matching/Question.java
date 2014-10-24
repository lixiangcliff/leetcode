package Regular_Expression_Matching;

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
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));

				

	}
	
	//brutal force
	//all explanation below:
	//http://blog.csdn.net/fightforyourdream/article/details/17717873
	//http://blog.csdn.net/linhuanmars/article/details/21145563
    public static boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    
    private static boolean helper(String s, String p, int i, int j){
    	if (j == p.length()){
    		return i==s.length();
    	}
    	if(j == p.length()-1){
    		return (i == s.length()-1) && isEqual(s, p, i, j);
    	}
    	//p.charAt(j+1) != '*'
    	if(j < p.length()-1 && p.charAt(j+1) != '*'){
    		if( i == s.length()){
    			return false;
    		}
    		if(isEqual(s, p, i, j)){
    			return helper(s, p ,i+1, j+1);
    		}else{
    			return false;
    		}
    	}
    	
    	//p.charAt(j+1) == '*'
    	while(i<s.length() && j<p.length() && isEqual(s, p, i, j)){
    		if(helper(s, p, i, j+2)){
    			return true;
    		}
    		i++;
    	}
    	///p.charAt(j+1) == '*' && !isEqual(s, p, i, j)
    	return helper(s, p, i, j+2);
    }
    
    private static boolean isEqual(String s, String p, int i, int j){
    	return s.charAt(i)==p.charAt(j) || p.charAt(j)=='.';
    }

}
