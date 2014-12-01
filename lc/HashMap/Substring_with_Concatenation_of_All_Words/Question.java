package Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		ArrayList result = findSubstring(S, L);
		for (int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
		
	}
	
	
	/**
	 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
	 * You are given a string, S, and a list of words, L, that are all of the
	 * same length. Find all starting indices of substring(s) in S that is a
	 * concatenation of each word in L exactly once and without any intervening
	 * characters.
	 * 
	 * For example, given: 
	 * S: "barfoothefoobarman" 
	 * L: ["foo", "bar"]
	 * 
	 * You should return the indices: [0,9]. (order does not matter).
	 */
	//O(n) way
	//http://blog.csdn.net/linhuanmars/article/details/20342851
	//此题核心在于左窗口的维护伴随着curMap的更新
	//此题很多细节！
	 public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(S == null || S.length()==0 || L == null ||L.length ==0){
	    		return result;
	    }
		//把L里面所有string都放入map中，<string, 该string在L中出现的次数>
		HashMap<String, Integer> map = new HashMap<String, Integer>();
    	int wordNum = L.length;
    	int wordLen = L[0].length();
    	for(int i=0; i<wordNum; i++){
    		if(map.containsKey(L[i])){
    			map.put(L[i], map.get(L[i])+1);
    		}else{
    			map.put(L[i], 1);
    		}
    	}
    	//关于为什么如下方法遍历，看图。
    	for(int i=0;i<wordLen;i++){
    		int count = 0;//记录在S中已经连续出现了几个符合要求的L[]中的string（符合题意的only once）
    		int left = i;//记录左窗口位置，方便以后可能的右移
    		HashMap<String, Integer> curMap = new HashMap<String, Integer>();//curMap要在j loop外，以为针对同一个i，不同的j都要参考同一个curMap
    		for(int j=i;j<=S.length()-wordLen;j+=wordLen){//j<=S.length()-wordLen因为当j==S.length()-wordLen，仍然符合条件
    			String str = S.substring(j, j+wordLen);
    			if(map.containsKey(str)){//当前str在map中能找到
    				//把str加入curMap
    				if(curMap.containsKey(str)){
    					curMap.put(str, curMap.get(str)+1);
    	    		}else{
    	    			curMap.put(str, 1);
    	    		}
    				
    				//一旦发现str在 S中出现次数大于在 L[]中, 我们就把left右移，直到str在S和L[]中出现的次数相等
    				if(curMap.get(str) > map.get(str)){
    					while(curMap.get(str) > map.get(str)){
    						//随着left右移，我们需要依次减少当前string在curMap的value（即当前string在curMap中出现的次数）
    						String temp = S.substring(left, left+wordLen); //记录当前要减少次数的string为temp
    						if(curMap.containsKey(temp)){//
    							curMap.put(temp, curMap.get(temp)-1);//减少temp在curMap出现的次数
    							//只有在temp在curMap中的次数已经小于map中，才减小count(即，如果curMap.get(temp)==map.get(temp)时，并不需要减小count )
    							if(curMap.get(temp)<map.get(temp)){  
    								count--;
    							}
    						}
    						left += wordLen;//left右移
    					}
    				}else{
    					count++;
    				}
    				
    				//count == wordNum时得到结果。此结果应该在j loop中得到，而不是在j loop外。因为对同一个i，可以有不同的结果
    				if(count == wordNum){
    					result.add(left);// 存入当前left值【注】不是 add(i)!!!
    					//当找到一个结果之后，left右移一个wordLen，继续寻找接下来可能的结果
    					String temp = S.substring(left, left+wordLen);
    					if(curMap.containsKey(temp)){//left右移，curMap必须随之更新
    						curMap.put(temp, curMap.get(temp)-1);
    					}
    					count--;//刚才count是等于wordNum(也意味着curMap.get(temp)==map.get(temp)）现在右移了一次（所以必然有curMap.get(temp)<map.get(temp)），所以count必须要减少1
    					left += wordLen;
    				}
    				
    			}else{//当前str在map中找不到，所以curMap以及count要从头累计起了
    				curMap.clear();
    				count = 0;
    				left = j+wordLen;//重新标记left
    			}
    		}
    	}
    	return result;
	 }
}
