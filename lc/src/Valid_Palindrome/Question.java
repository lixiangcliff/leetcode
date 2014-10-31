package Valid_Palindrome;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
		String s = "aa2";
		//System.out.println(isPalindrome(s));
		System.out.println('1'-'9');
	}
	
    public static boolean isPalindrome(String s) {
        if(s==null){
        	return false;
        }
        s = s.trim();
        if(s.length() <= 1){
        	return true;
        }
        int l = 0;
        int r = s.length()-1;
        while(l<r){
        	//considering only alphanumeric characters
        	while(!(s.charAt(l)>='a' && s.charAt(l)<='z') && !(s.charAt(l)>='A' && s.charAt(l)<='Z') && !(s.charAt(l)>='0' && s.charAt(l)<='9') && l<s.length()-1){
        		l++;
        	}
        	while(!(s.charAt(r)>='a' && s.charAt(r)<='z') && !(s.charAt(r)>='A' && s.charAt(r)<='Z') && !(s.charAt(r)>='0' && s.charAt(r)<='9') && r>0){
        		r--;
        	}
        	if(l<r){
        		//'A' is considered to be same as 'a' for Palindrome checking
        		if(Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r))){
        			return false;
        		}
        		l++;
        		r--;
        	}
        }
        return true;
    }

}
