package Excel_Sheet_Column_Title;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.convertToTitle(53));
		//System.out.println(q.getStr(1));
	}
	
	/**
	 * https://leetcode.com/problems/excel-sheet-column-title/
	 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
		For example:
		
		    1 -> A
		    2 -> B
		    3 -> C
		    ...
		    26 -> Z
		    27 -> AA
		    28 -> AB 
	 */
	
	//credit to Zhe
    public String convertToTitle(int n) {
    	if (n < 1) {
    		return null;
    	}
    	StringBuilder sb = new StringBuilder();
    	while (n > 0) {
    		n--;
    		sb.append((char)('A' + n % 26));
    		n /= 26;
    	}
    	return sb.reverse().toString();
    }
    

}
