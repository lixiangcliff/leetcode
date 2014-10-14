package ZigZag_Conversion;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING",3));
		
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21145039
    public static String convert(String s, int nRows) {
        if(s == null || s.length() == 0 || nRows <= 0){
        	return "";
        }
        if (nRows == 1){
        	return s;
        }
        int size = 2*nRows-2;
        StringBuilder sb = new StringBuilder();
        //for(int i=0; i< s.length();i++){ // wrong!! 
        for(int i=0; i< nRows;i++){
        	for(int j=i;j<s.length();j+=size){ 
        		sb.append(s.charAt(j));// going down
        		if (i!=0 && i!= nRows-1 && j+size-2*i < s.length()){// going up
            		sb.append(s.charAt(j+size-2*i));
            	}
        	}
        }
        return sb.toString();
    }

}
