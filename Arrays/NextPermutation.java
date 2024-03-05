//Question Link
//https://leetcode.com/problems/next-permutation/description/

package Arrays;
import java.util.Arrays;
class NextPermutation {
    public static void reverse(int arr[],int s,int e){
        if(s>=e) return;
        while(s<e){
            int temp=arr[e];
            arr[e]=arr[s];
            arr[s]=temp;
            s++;
            e--;
        }
    }
    public void nextPermutation(int[] arr) {
        int n =arr.length;
        for(int i=n-1;i>=1;i--){

            if(arr[i-1]<arr[i]){

                int j=n-1;
                int min=Integer.MAX_VALUE;
                int ith=-1;
                while(j>=i){
                   
                    if(arr[j]<min && arr[j]>arr[i-1]){
                        min=arr[j];
                        ith=j;
                    }
                    j--;
                }

                int temp=arr[ith];
                arr[ith]=arr[i-1];
                arr[i-1]=temp;

                reverse(arr,i,n-1);
                return;
            }
        }

        reverse(arr, 0, n-1);
    }
}