package First_Missing_Positive;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A =  {3,4,4,4,-1,1};
		int[] A =  {3,4,-1,1};
		System.out.println(firstMissingPositive(A));
	}
	

	//http://blog.csdn.net/linhuanmars/article/details/20884585
	//our purpose it to make: A[0]==1, A[1]==2...
	//中心思想：遍历array，通过swap让A[i]的值为i+1；第二次遍历时哪个A[i]!=i+1 即是缺失的第一个正数
	//下面重点说如何swap
    public static int firstMissingPositive(int[] A) {
    	if (A == null || A.length == 0){
    		return 1;
    	}
    	for(int i=0;i<A.length;i++){
    		/*
    		 * 我们针对每一位做处理（swap），直到这位彻底处理完（或者已经不满足swap条件）了才再往右挪一位
    		 * 处理每位时，只有满足以下三种情况才做swap，否则
    		 * 1.A[i] > 0(负数不处理)
    		 * 2.A[i] <= A.length(长度为A.length的array中，最后一位A[A.length-1]能符合题意的数值为A.length，所以一旦A[i]>A.length，则不合我们的中心思想)
    		 * 3.A[i] != A[A[i]-1]（swap的意图就是把A[i]的值找到他该去的地方（index ==A[i]-1），所以如果A[i]==A[A[i]-1]我们就不需要也不能交换，否则下面i-- 之后，i停留，会陷入死循环 ）
    		 */
    		if(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i]-1]){ 
    			//下面的swap，在A[A[i]-1]<0时会导致之后index越界（index<0）
    			//int temp = A[i]; //Wrong!! important!  
    			//A[i] = A[A[i]-1]; //因为如果A[A[i]-1]<= 0, 则新的 A[i]<=0, 则A[i]-1 <= -1,
    			//A[A[i]-1] = temp; //于是当"A[A[i]-1] = temp"会导致index越界
    			//而下面的就不会
                int temp = A[A[i]-1];  
                A[A[i]-1] = A[i];  
                A[i] = temp;  
    			i--;// i停留在此位，直到每次swap之后此位的新数值都去了它们该去的地方
    		}
    	}
    	for(int i=0; i<A.length;i++){
    		if(A[i] != i+1){
    			return i+1;
    		}
    	}
    	//如果code能执行到这里，说明A[0]==1, A[1]==2 ...A[A.length-1]=A.length,所以下一个正数就是A.length+1
    	return A.length+1; 
    }

}
