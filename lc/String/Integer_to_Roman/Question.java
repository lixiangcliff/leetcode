package Integer_to_Roman;
import java.math.BigDecimal;
public class Question {

	/**
	 * @param args
	 *  I = 1;
		V = 5;
		X = 10;
		L = 50;
		C = 100;
		D = 500;
		M = 1000;
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1990));
		
	}
	/*I = 1;
	V = 5;
	X = 10;
	L = 50;
	C = 100;
	D = 500;
	M = 1000;*/
	//http://blog.csdn.net/havenoidea/article/details/11848921
	//http://stupidcodergoodluck.wordpress.com/2014/03/31/leetcode-integer-to-roman/
	// each symbol is a base. we evaluate how many base can we extract from number each time.   
    public static String intToRoman(int num) {
    	StringBuffer sb = new StringBuffer();
    	String[] symbols = {"M", "CM", "D", "CD", "C","XC","L","XL","X","IX","V","IV","I"};
    	int[] values =    {1000, 900, 500, 400, 100, 90, 50 ,40 ,10, 9, 5, 4 ,1};
    	for(int i=0; i<values.length;i++){
    		while(num>=values[i]){
    			num -= values[i];
    			sb.append(symbols[i]);
    		}
    	}
    	return sb.toString();
        
    }

}
