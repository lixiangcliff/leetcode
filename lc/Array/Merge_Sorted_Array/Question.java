package Merge_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,7,0,0,0};
		int[] B = {2,6,8};
		//int[] B = {};
		int aLen = 4;
		merge(A, aLen, B, B.length);
		for(int i=0;i< aLen+B.length;i++){
			System.out.println(A[i]+ ",");
		}

	}
	public static void merge(int A[], int m, int B[], int n){
		//【注】“ A.length == 0 || B.length == 0” 的条件不能加在这里，
		//因为，如果A为空，我们仍然要把B merge到A里，而不是什么都不做就return
		if(A == null || B == null){
			return;
		}
		//从后往前扫，以避免覆盖还未做比较的元素
		int aEnd = m-1;
		int bEnd = n-1;
		int end = m+n-1;
		//终止条件：A和B任何一个处理完了就跳出循环
		while(aEnd >= 0 && bEnd >= 0){ //【注】 aEnd和bEnd都可以为0， 因为这里aEnd和bEnd都是index，而不是长度。
			if (A[aEnd] > B[bEnd]){
				A[end--] = A[aEnd--];
			}else{
				A[end--] = B[bEnd--];
			}
		}
		//如果B中还有剩余未比较的元素【注】注意此处边界条件，bEnd==0时还剩一个元素仍要处理！
		while(bEnd >= 0){
			A[end--] = B[bEnd--];
		}
		//【注】 无需考虑(处理)A中是否还有未比较的元素，因为如果有，就把它放在那里就好了（因为A已经有序）
	}
}
