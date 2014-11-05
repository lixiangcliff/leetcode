package Pascals_Triangle_II;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result = getRow(4);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i) + ",");
		}
	}
	
	//to use O(k) space only: rolling array
	//http://blog.csdn.net/linhuanmars/article/details/23311629
	//http://blog.csdn.net/abcbc/article/details/8982651
	//http://fisherlei.blogspot.com/2012/12/leetcode-pascals-triangle-ii.html
	//一维DP，从后往前扫。
	//【注】因为数据类型为ArrayList所以随着add元素，size会增长,所以要处理好后面的index问题
	//而且ArrayList的元素一定要先数据，之后才能改值，即要先add 然后才能set
	//【注】此题和Pascals_Triangle_I 对kth row的定义有区别
	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		if (rowIndex < 0){
			return result;
		}
		result.add(1);//row 0
		for(int i=1;i<=rowIndex;i++){//从第row 1到第row n
			for(int j=result.size()-1;j>0;j--){//从后往前扫
				result.set(j, result.get(j) + result.get(j-1));
			}
			result.add(1);//补最后一个1
		}
		return result;
	}
}
