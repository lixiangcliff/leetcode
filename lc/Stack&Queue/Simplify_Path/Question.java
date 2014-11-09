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
        	while(i<path.length() && path.charAt(i) != '/'){//以"/"来分隔
        		temp.append(path.charAt(i++));
        	}
        	//反之如果i==index，即path.charAt(i) == '/'，则直接跳过。
        	//比如遇到开头的"/abc..." 或者中间连续的"abc//def"
        	if(i!=index){
        		/*
        		 * 不能用temp.toString() == ".."
        		 * .equal():检查内容是否相同
        		 * == ：检查是否是对同一个object的引用
        		 * http://stackoverflow.com/questions/767372/java-string-equals-versus
        		 * "The function checks the actual contents of the string, the == operator checks whether the references to the objects are equal. "
        		 */
        		if(temp.toString().equals("..")){//向上一层，即弹出一个元素
        			if(!stack.isEmpty()){
        				stack.pop();
        			}
        		}else if(!temp.toString().equals(".")){//省略了equals(".")的情况（该情况下什么也不做）
        			stack.push(temp.toString());//如果既不是".."，也不是"."，则入栈。
        		}
        	}
        	i++;
        }
        if(!stack.isEmpty()){
        	//e.g原path为/a/b/c; 压入栈之后从栈顶到栈底顺序为c,b,a; toArray之后 为{c,b,a}
        	String[] strArr = stack.toArray(new String[stack.size()]);//LinkedList转数组，以方便用下标取元素
        	//若要恢复原顺序则需要从后往前append
        	for(int j=strArr.length-1; j>= 0; j--){
        		result.append("/" + strArr[j]); //append时，要用"/",而不是'/'（String vs Char）
        	}
        	return result.toString();
        }
        return "/";
    }

}
