//Question Link: https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
import java.util.*;
public class MissingAndRepeating {

public static int[] inversionNo(int []a) {
       int[] ans = {-1,-1};
       int n=a.length;
       int p=-1,q=-1;
       for(int i=0;i<n;i++){
           int index = Math.abs(a[i])-1;
           a[index] = -1*a[index];
           if(a[index]>0){
               p=index+1;
           }
       }
       for(int i=0;i<n;i++){
           if(a[i]>0 && p!= i+1){
               q=i+1;
           }
       }
       ans[0]=p;
       ans[1]=q;
       return ans;
   }


}
