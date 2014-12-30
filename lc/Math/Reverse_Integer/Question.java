package Reverse_Integer;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1000000003));

	}
	
	/*public static int reverse(int x) {
		int sign;
		String value;
		if (x<0){
			sign = -1;
			value = Integer.toString(x).substring(1);
		}else{
			sign = 1;
			value = Integer.toString(x);
		}
		StringBuffer sb = new StringBuffer("");
		for (int i = value.length()-1; i>= 0;i--){
			sb.append(value.charAt(i));
		}
		return Integer.parseInt(sb.toString())*sign;
    }*/
	
	//another way
	public static int reverse(int x) {
		int sign = 1;
		if (x<0){
			sign =-1;
			x *= (-1);
		}
		int result = 0;
		while(x>0){
			int remainder = x%10;			
			result = result*10 + remainder;
			x /= 10;
		}
		return result*sign;
	}

}
