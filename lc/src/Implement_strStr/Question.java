package Implement_strStr;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("h", "h"));
	}
	
	//brutal force
	//http://blog.csdn.net/linhuanmars/article/details/20276833
    public static String strStr(String haystack, String needle) {
        if(haystack ==  null || needle == null || needle.length()==0){
        	return haystack;
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen < nLen){
        	return null;
        }
        //for (int i=0;i<hLen-nLen;i++){//wrong!
        for (int i=0;i<=hLen-nLen;i++){
        	boolean found = true;
        	for(int j=0;j<nLen;j++){
        		while(needle.charAt(j) != haystack.charAt(i+j)){
        			found = false;
        			break;
        		}
        	}
        	if(found){
        		return haystack.substring(i);
        	}
        }
        return null;
    }
    
}
