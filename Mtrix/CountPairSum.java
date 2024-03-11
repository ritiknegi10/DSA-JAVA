//Question Link
//https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1

class countPairSum {
    int countPairs(int matrix1[][], int matrix2[][], int N, int x) {
        
        int output = 0;
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int target = x - matrix1[i][j];
                
                if (target < 0)
                    continue;
                
                if (binarySearchMatrix(matrix2, N, target))
                    output ++;
            }
        }
        
        return output;
    }
    
    private boolean binarySearchMatrix(int[][] matrix, int N, int target) {
        
        int top = 0, bottom = N - 1;
        int leftIndex = 0, rightIndex = N - 1;
        
        while (top <= bottom)
        {
            int mid = (top + bottom) / 2;
            
            if (matrix[mid][leftIndex] <= target && target <= matrix[mid][rightIndex])
            {
                while (leftIndex <= rightIndex)
                {
                    int Mid = (leftIndex + rightIndex) / 2;
                
                    if (matrix[mid][Mid] == target)
                        return true;
                
                    else if (matrix[mid][Mid] < target)
                        leftIndex = Mid + 1;
                
                    else
                        rightIndex = Mid - 1;
                }
                
                return false;
            }
            
            else if (matrix[mid][leftIndex] <= target)
                top = mid + 1;
            
            else 
                bottom = mid - 1;
        }
        
        return false;
    }
}