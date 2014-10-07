package Permutations;

public class SF_Quanpailie{
   	public static void main(String[] args)
    {
           int list[]={1,2,3,4};
           perm(list,0,4);
    }

    public static void  swap(int[] a,int i,int j){
           int temp=a[i];
           a[i]=a[j];
           a[j]=temp;
    }

    public static void perm(int[] list,int k,int m){
           if (k==m)
           {
                  for (int i=0; i<m;i++ )
                  {
                         System.out.print(list[i]);
                  }
                  System.out.println();
           }else {
                  for (int i=k;i<m ;i++ )
                  {
                         swap(list,k,i);
                         perm(list,k+1,m);
                         swap(list,k,i);
                  }
           }
    }
}
