//Problem link
//https://leetcode.com/problems/rotate-image/description/

package Mtrix;
import java.util.*;
public class Rotate {
    public static void rotateMatrix(int [][]mat){
        for(int i=0;i<mat.length;i++)
        {

            for(int j=i;j<mat[0].length;j++)

            {

                int temp=0;

                temp =mat[i][j];

                mat[i][j]=mat[j][i];

                mat[j][i]=temp;

            }

        }

       for(int i=0;i<mat.length;i++)

        {

            for(int j=0;j<mat.length/2;j++)

            {

                int temp=0;

                temp = mat[i][j];

                mat[i][j]=mat[i][mat.length-j-1];

                mat[i][mat.length-j-1]=temp;

            }

        }

    }

}