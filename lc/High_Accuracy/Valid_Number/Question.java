package Valid_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/valid-number/
	 * Validate if a given string is numeric.
	 * 
	 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
	 * "2e10" => true Note: It is intended for the problem statement to be
	 * ambiguous. You should gather all requirements up front before
	 * implementing one.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/23809661
    public boolean isNumber(String s) {
        if(s == null || s.length() ==0){
        	return false;
        }
        s = s.trim();
        if (s.length() == 0){
        	return false;
        }
        boolean dotFlag = false;
        boolean eFlag = false;
        for(int i=0;i<s.length();i++){
        	switch(s.charAt(i)){
	        	case '.':
	        		//take opposite as condition for false 
	        		//（1）前面不能有小数点或者‘e’和‘E’；（2）前一位是数字（不能是第一位）或者后一位要是数字（不能是最后一位）。
	        		if(dotFlag || eFlag || ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))&&(i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')))){
	        			return false;
	        		}
	        		dotFlag = true;
	        		break;
	        	case '+':
	        	case '-':
	        		//（1）必须是第一位或者在‘e’和‘E’后一位；（2）后一位要是数字。(3) next postion cannot be '.'
	        		if(i!=0&&(s.charAt(i-1)!='e' && s.charAt(i-1)!='E') || (i==s.length()-1 || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9' || s.charAt(i+1)=='.' ))){
	        			return false;
	        		}
	        		break;
	        	case 'e':
	        	case 'E':
	        		//（1）前面不能有‘e’和‘E’出现过；（2）不能是第一位（前面没数字科学计数没有意义）或者最后一位（后面没数字就不用写指数了）。
	        		if(eFlag || i == 0 || i == s.length()-1 ){
	        			return false;
	        		}
	        		eFlag = true;
	        		break;
	        	case '0':
	        	case '1':
	        	case '2':
	        	case '3':
	        	case '4':
	        	case '5':
	        	case '6':
	        	case '7':
	        	case '8':
	        	case '9':
	        		break;
	        	default:
	        		return false;
        	}
        }
        return true;
    }

}
