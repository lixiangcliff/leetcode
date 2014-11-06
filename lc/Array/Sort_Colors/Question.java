package Sort_Colors;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,2,1,2,0,1,1,1,2,0};
		sortColors(A);
		for (int i=0;i<A.length;i++){
        	System.out.println(A[i] + ",");
        }

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24286349
    public static void sortColors(int[] A) {
        if(A == null || A.length == 0){
        	return;
        }
        //idx0表示最后一个是0的元素的index，idx1类似，表示1的；
        int idx0 = 0;
        int idx1 = 0;
        for(int i=0; i<A.length;i++){
        	/*
        	 * 对每种情况（A[i]==0,1,2）,一上来都要进行A[i]=2，这是为了把之前欠的2给补上
        	 * （如果idx1==i,A[i]可能被覆盖，但是这一步必须要做）
        	 */
        	//A[i]==0时，
        	if(A[i] == 0){
        		A[i] = 2;
        		/*A[idx0++] = 0; //wrong!
        		A[idx1++] = 1;*/
        		/*
        		 * 以下两行的顺序matters!上面是错的。下面是对的
        		 * 道理和先要对A[i]赋值(A[i]=2)类似。
        		 * 在idx1==idx0时，如果后做A[idx1++] = 1，那么本该为0的这位就会被覆盖
        		 */
        		A[idx1++] = 1;
        		A[idx0++] = 0; 
        	}else if(A[i] == 1){
        		A[i] = 2;
        		A[idx1++] = 1;
        	}
        	//可以这么理解：如果A[i]等于2时候，idx0不增加，idx1也不增加。i单独增加的就是含有的2的个数
        	//其实把省略的部分写完整了，应该有如下表示：
        	/*else{
        		A[i] = 2;
        	}*/
        	//但是 这个else的情况本身就是A[i] == 2, 然后在此条件下进行的操作又是A[i] = 2，所以完全没必要。故省略之。
        }
        return;
    }

}
