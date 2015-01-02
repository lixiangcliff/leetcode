package Length_of_Last_Word;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "    hel      ";
		System.out.println(lengthOfLastWord(s));

	}
	
    public static int lengthOfLastWord(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
	
    	boolean foundLastNonSpace = false;
    	int lastNonSpace=-1;
    	int leftSpace=-1;    	
    	for(int i=s.length()-1;i>=0;i--){
    		if (s.charAt(i) != ' ' && !foundLastNonSpace){
    			lastNonSpace = i;
    			foundLastNonSpace = true;
    			continue;
    		}
    		if(foundLastNonSpace && s.charAt(i) == ' '){
    			leftSpace = i;
    			break;
    		}
    	}
        return lastNonSpace-leftSpace;
    }

}
