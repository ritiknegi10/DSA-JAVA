//Question Link: https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Median {

        static int numberequals(int []matrix,int mid){
      
          int n=matrix.length;
      
          int low=0;
      
          int high=n-1;
      
          int ans=n;
      
          while(low<=high){
      
            int m=(low+high)/2;
      
              if(matrix[m]>=mid){  //lower bound  
      
                ans=m;
      
                high=m-1;
      
              }
      
              else{
      
                low=m+1;
      
              }
      
          }
      
          return ans;
      
        }
      
           
      
          public static int findMedian(int matrix[][], int m, int n) {
      
              // Write your code here
      
              int low = 1;
      
          int high = 1000000000; // constraint me de rakha hia 10^9 me ishliye liyaa itna bada
      
             int ans=-1;
      
          while(low<=high){
      
            int mid=(low+high)/2;
      
            int count=0;
      
              for(int i=0;i<m;i++){
      
                 count+= numberequals(matrix[i],mid);          
      
                    }
      
            int howManyQuals=count;
      
            if(howManyQuals<=(n*m)/2){
      
              low=mid+1;
      
              ans=mid;
      
            }
      
            else{
      
              high=mid-1; 
      
            }
      
                
      
          }
      
          return ans;
      
        }
            
}
