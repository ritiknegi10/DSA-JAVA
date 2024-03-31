//link https://www.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1?page=1&difficulty=Hard&sortBy=submissions

public class Sudoko {
 
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                
                if(grid[i][j]==0){
                    for(int k=1 ;k<=9; k++){
                        if(isValid(grid , i , j , k)){
                            grid[i][j]=k;
                            if(SolveSudoku(grid)){
                                return true ;
                            }
                            else{
                                grid[i][j]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        
        return true ;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i = 0 ;i<grid.length;i++){
            for(int j = 0 ;j<grid.length;j++){
                if(i==grid.length-1 && j==grid.length-1){
                    System.out.print(grid[i][j]) ; 
                }else{
                System.out.print(grid[i][j]+" ") ;
                }
            }
        }
    }
    
    static boolean isValid(int grid[][], int row , int col , int k){
        
        for(int i=0 ; i<9 ; i++){
            //check columns 
            if(grid[row][i]==k) return false;
            //check rows
            if(grid[i][col]==k) return false;
            //check 3*3 matrix 
            if(grid[3*(row/3)+i/3][3*(col/3)+i%3] == k) return false;
        }
        return true ;
    }

}
