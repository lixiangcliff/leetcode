package Simplify_Path;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/.."));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/23972563
    public static String simplifyPath(String path) {
        if(path == null || path.length()==0){
        	return "";
        }
        LinkedList<String> stack = new LinkedList<String>();
        StringBuilder result = new StringBuilder();
        int i=0;
        while(i<path.length()){
        	int index = i;
        	StringBuilder temp = new StringBuilder();
        	while(i<path.length() && path.charAt(i) != '/'){
        		temp.append(path.charAt(i++));
        	}
        	if(i!=index){
        		//if(!stack.isEmpty() && temp.toString() == ".."){ wrong!
        		//http://stackoverflow.com/questions/767372/java-string-equals-versus
        		//"The function checks the actual contents of the string, the == operator checks whether the references to the objects are equal. "
        		//if(!stack.isEmpty() && temp.toString().equals("..")){
        		//	stack.pop();
        		//when input is "/..", above code will get wrong answer "/.."
        		//but below will not!
        		if(temp.toString().equals("..")){
        			if(!stack.isEmpty()){
        				stack.pop();
        			}
        		}else if(!temp.toString().equals(".")){
        			stack.push(temp.toString());
        		}
        	}
        	i++;
        }
        if(!stack.isEmpty()){
        	String[] strArr = stack.toArray(new String[stack.size()]);
        	for(int j=strArr.length-1; j>= 0; j--){
        		//result.append(strArr[i]+'/'); //wrong.. 1. wrong order; 2.not '/' but "/" 3. it is j not i!
        		result.append("/" + strArr[j]);
        	}
        	return result.toString();
        }
        return "/";
    }

}
