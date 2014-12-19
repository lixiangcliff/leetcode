package Generate_Parentheses;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Heelow!");
	}
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> result =  new ArrayList<String>();
    	addParen(result, "", n, n);
    	return result;
    }
    
    private void addParen(ArrayList<String> result, String str, int left, int right){ // left means how many "(" are still unused
    	if (left < 0 || left > right){
    		return;
    	}
    	if (left == 0 && right == 0){ // all parens have been used. then finished one possible combination    		
    		result.add(str);
    	}
    	// use left
    	addParen(result, str+"(", left-1, right);
    	// use right
    	addParen(result, str+")", left, right-1);
    }

}
