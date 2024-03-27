//Question link https://www.geeksforgeeks.org/problems/find-shortest-safe-route-in-a-matrix/1
import java.util.LinkedList;
import java.util.Queue;

public class ShortestSfeRoute {
   
     int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, 1, 0, -1};

    int ans = Integer.MAX_VALUE;

    void f(int row, int col, int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        q.offer(new int[]{row, col, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            if (y == n - 1) {
                ans = Math.min(ans, steps + 1);
            }
            vis[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nrow = x + delrow[i];
                int ncol = y + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    q.offer(new int[]{nrow, ncol, steps + 1});
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }

    public int findShortestPath(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];

        // Mark unsafe spots and mark visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nrow = i + delrow[k];
                        int ncol = j + delcol[k];

                        if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                            mat[nrow][ncol] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0; // Mark unsafe spot
                    vis[i][j] = 1; // Mark visited
                }
            }
        }

        // Check for each cell in the leftmost column
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 1) {
                f(i, 0, mat); // Function for every '1' in the 0th column
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

}
