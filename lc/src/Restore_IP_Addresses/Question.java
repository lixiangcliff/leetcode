package Restore_IP_Addresses;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24683699
    public ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> result = new ArrayList<String>();
        if(s==null || s.length()==0){
        	return result;
        }
        helper(s, 0, 1, "", result);
        return result;
    }
    
    private void helper(String s, int index, int segment, String item, ArrayList<String> result){
    	if(index >= s.length()){
    		return;
    	}
    	if(segment == 4){
    		String str = s.substring(index);
    		if(isValid(str)){
    			
    			result.add(item+'.'+str);
    		}
    		return;
    	}
    	for(int i=1; i<4 && (i+index)<s.length(); i++){
    		String str = s.substring(index, index+i);
    		if(isValid(str)){
    			if(segment == 1){
    				//helper(s, index+1, segment+1, str, result); //wrong!
    				helper(s, index+i, segment+1, str, result);
    			}else{
    				helper(s, index+i, segment+1, item+'.'+str, result);
    			}
    		}
    	}
    }
    
    private boolean isValid(String str){
    	if(str == null || str.length() == 0 || str.length()>3){
    		return false;
    	}
    	if(str.charAt(0)=='0' && str.length()>1){
    		return false;
    	}
    	int num = Integer.parseInt(str);
    	return (num>=0 && num<=255);
    }

}
