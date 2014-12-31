package String_to_Integer_atoi;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("       2134x    125"));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21145129
    public static int atoi(String str) {
        if(str == null || str.length() == 0){
        	return 0;
        }
        str = str.trim();
        if(str.length() == 0){
        	return 0;
        }
        boolean isNeg = false;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
        	if(str.charAt(0) == '-'){
        		isNeg = true;
        	}
        	str = str.substring(1);
        }
        int result = 0;
        for(int i=0;i<str.length();i++){
        	if(str.charAt(i)<'0' || str.charAt(i)>'9'){
        		break;
        	}
        	int digit = (int)(str.charAt(i)-'0');
        	//wrong!
        	/*if (isNeg){
        		//if(result <-((Integer.MIN_VALUE+digit)/10)){ //wrong!
        		if(result > -((Integer.MIN_VALUE+digit)/10)){
        			break;
        		}
        	}else {
        		if(result > (Integer.MAX_VALUE-digit)/10){
        			break;
        		}
        	}*/
        	if (isNeg && result > -((Integer.MIN_VALUE+digit)/10)){
        			return Integer.MIN_VALUE;
        	}else if(!isNeg && result > (Integer.MAX_VALUE-digit)/10){
        			return Integer.MAX_VALUE;
        	}
        	result = result*10 + digit;
        }
        return isNeg?-result:result;
    }

}
