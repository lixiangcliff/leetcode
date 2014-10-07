package Single_Number;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,4,12,-5, -1657, 13,12,6,2, -1657, -5673,3,1,4,6,13, -5, 0 , 0, -5673, -32768};
		SingleNumber s = new SingleNumber();
		System.out.println(s.singleNumber(A));
		/*int a = 0^12346;
		System.out.println(a);*/
		

	}
	
	
	/*public int singleNumber(int[] A) {
		 //int range is:-32768 to +32767
		 boolean[] bArray = new boolean[65536]; //all possible integer values. True means odd times; False means even times
		 for(int i =0; i < A.length; i++){
			if (A[i] < 0){
				A[i] += 65536; 
			}
			if (bArray[A[i]] == false){
				bArray[A[i]] = true;
			} else{
				bArray[A[i]] = false;
			}			 
		 }
		 for (int i=0; i < bArray.length; i++){
			 if (bArray[i] == true){
				 if (i > 32767){
					 return i-65536;
				 }else{
					 return i;
				 }
			 }
		 }
		 return 0;		 
	 }*/
	
	 //advanced! other's idea; this does not require extra memory
        public int singleNumber(int[] A) {
            int ans = 0;
            for (int i : A) {
                ans ^= i; //a^a is 0; a^0 is a;
            }
            return ans;
        }
	    


}

   