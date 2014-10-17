package Sqrt_x;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(2147395599));

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20089131
    public static int sqrt(int x) {
    	if(x<0){
    		return -1;
    	}
    	if(x<=1){
    		return x;
    	}
    	int l = 1;
    	int r = x/2;
    	int m = 1;
    	while(1<=r){
    		m = (l+r)/2;
    		//if(m*m<=x && x<(m+1)*(m+1)){ // wrong!! because if x is too big e.g "9999999" m*m will overflow. So must use division instead of multiplication 
    		if(m<=x/m && x/(m+1)<m+1){
    			return m;
    		}
    		//if (x>m*m){ // wrong! same reason as above!
    		if (x/m>m){
    			l = m+1;
    		}else{
    			r = m-1;
    		}
    	}
        return m;
    }
	
	//testing
/*	public static int sqrt(int x) {  
	    if(x<0) return -1;  
	    if(x==0) return 0;  
	    int l=1;  
	    int r=x/2+1;  
	    while(l<=r)  
	    {  
	        int m = (l+r)/2;  
	        if(m<=x/m && x/(m+1)<m+1)  
	            return m;  
	        if(x/m<m)  
	        {  
	            r = m-1;  
	        }  
	        else  
	        {  
	            l = m+1;  
	        }  
	    }  
	    return 0;  
	} */

}
