//Question: Find the peak element in the matrix
//Link: https://leetcode.com/problems/find-peak-element-ii/
public class FindElement {
      public static int findMaxIndex(int [][]mat, int n, int m, int col){
          int maxValue=-1;
         int index=-1;
  
            for(int i=0; i<n; i++){
              if(mat[i][col]>maxValue){
                     maxValue=mat[i][col];

                    index=i;
                          }          }
          return index;
      }
    
        public static int[] findPeakGrid(int [][]G){

            int n=G.length;
            int m=G[0].length;
  
            int low=0;
        int high=m-1;
 
            while(low<=high){
   
                int mid=(low+high)/2;
             int maxRowIndex = findMaxIndex(G,n,m,mid);
               int left= 0<=mid-1 ? G[maxRowIndex][mid-1] : -1;   
                int right= mid+1<m ? G[maxRowIndex][mid+1] : -1;  
                if(G[maxRowIndex][mid]>left && G[maxRowIndex][mid]>right){
                       return new int[] {maxRowIndex,mid};
               }
                   else if(G[maxRowIndex][mid] < left) high=mid-1;
               else low=mid+1;
         }

            return new int[] {-1,-1};
        }     
}
