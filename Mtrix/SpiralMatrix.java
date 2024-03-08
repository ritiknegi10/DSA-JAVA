//Question link
//https://www.codingninjas.com/studio/problems/spiral-matrix_6922069?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=SUBMISSION

package Mtrix;
import java.util.*;

public class SpiralMatrix {

    public static int[] spiralMatrix(int [][]MATRIX) {

        // Write your code here.

        int n = MATRIX.length;

        int m = MATRIX[0].length;

        int ans[]=new int[n*m];

        int top=0,left=0,right=m-1,bottom=n-1;

        int c=0;

        while(top<=bottom && left<=right)

        {

            // moving left to right

            for(int i=left;i<=right;i++)

            {

                ans[c]=MATRIX[top][i];

                c++;

            }

            top++;

 

            // moving from top to bottom

            for(int i=top;i<=bottom;i++)

            {

                ans[c]=MATRIX[i][right];

                c++;

            }

            right--;

 

            // moving right to left

            if(top<=bottom)

            {

                for(int i =right;i>=left;i-- )

                {

                    ans[c]=MATRIX[bottom][i];

                    c++;

                }

                bottom--;

            }

            

 

            // moving from bottom to top

            if(left<=right)

            {

                for(int i =bottom;i>=top;i-- )

                {

                    ans[c]=MATRIX[i][left];

                    c++;

                }

                left++;

            }

 

        }

        return ans;

    }

}

