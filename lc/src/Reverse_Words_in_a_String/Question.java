package Reverse_Words_in_a_String;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("      the      sky         is  blue     "));
	}
	
    public static String reverseWords(String s) {
    	if (s == null || s.length() == 0){
    		return "";
    	}
    	s = s.trim();
    	if(s.length() == 0 || s.length() == 1){
    		return s;
    	}
    	String result = "";
    	StringBuilder temp = new StringBuilder();
    	for(int i=0;i<=s.length(); i++){
    		if (i==s.length()){
				result = temp.toString() + result;
				return result;
    		}
    		if(s.charAt(i) == ' ' || s.charAt(i) == '	'){
    			if(temp.length() == 0){
    				continue;
    			}else{
    				result = " " + temp.toString() + result;
        			temp.setLength(0);
    			}
    		}else{
    			temp.append(s.charAt(i));
    		}
    	}
    	return result;
    }

}
