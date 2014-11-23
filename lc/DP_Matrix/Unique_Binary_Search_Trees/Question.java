package Unique_Binary_Search_Trees;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(2));

	}
	
	//http://segmentfault.com/blog/riodream/1190000000471615
	public static int numTrees(int n) {
		 //multiplication principle + recursion
	       if(n==0||n==1){
	           return 1;
	       }
	      
		   int number=0;
		   for(int i=1;i<=n;i++){ //i <=n!!!
		       number += (numTrees(i-1)*numTrees(n-i)); //left*right
		   }
		   return number;
	       
	      
        
        
        
    }

}
