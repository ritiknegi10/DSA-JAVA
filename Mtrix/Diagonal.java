//problem link
//https://www.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1
public class Diagonal {
    

    public int[] matrixDiagonally(int[][] mat) {
         int n = mat.length;
        int[] result = new int[n * n];
        int index = 0;
        int row = 0, col = 0;
        boolean up = true;

        // Traverse each element in the matrix
        for (int i = 0; i < n * n; i++) {
            result[index++] = mat[row][col];

            if (up) {
                if (col == n - 1) {
                    row++;
                    up = false;
                } else if (row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == n - 1) {
                    col++;
                    up = true;
                } else if (col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }

}
