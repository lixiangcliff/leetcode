package Add_Binary;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11","1"));
	}
	//my way
	//cannot handle super "long" binary...
	//won't pass leetcode test case when
	// a=10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101
	// b=110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011
   /* public static String addBinary(String a, String b) {
        int sumInt = binToInt(a) + binToInt(b);
        System.out.println("sumInt:" + sumInt);
        return intToBin(sumInt);
    }
    
    private static int binToInt(String str){
    	if(str == null || str.length()==0){
    		return 0;
    	}
    	int result = 0;
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)=='1'){
    			result += Math.pow(2, str.length()-1-i);
    		}
    	}
    	return result;
    }
    
    //http://zhidao.baidu.com/question/144889190.html
    private static String intToBin(int x){
    	if (x == 0){
    		return "0";
    	}
    	String result = "";
    	for(int i=x; i>=1 ;i/=2){
    		String sum = i%2==0 ? "0" : "1";
    		result = sum + result;
    	}
    	return result;
    }*/

	public static String addBinary(String a, String b) {
		int m = a.length();
		int n = b.length();
		int k = Math.max(m, n);
		int carry=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<k;i++){
			int aValue = i<m ? getValue(a.charAt(m-1-i)) : 0;
			int bValue = i<n ? getValue(b.charAt(n-1-i)) : 0;
			int value = aValue + bValue + carry;
			int digit = value % 2;
			carry = value / 2;
			sb.append(digit);
		}
		if (carry == 1){
			sb.append(1);
		}
		return sb.reverse().toString();
	}
	
	private static int getValue(char x){
		if(x == '1'){
			return 1;
		}else if(x == '0'){
			return 0;
		}else{
			return Integer.MAX_VALUE;
		}
	}
}
