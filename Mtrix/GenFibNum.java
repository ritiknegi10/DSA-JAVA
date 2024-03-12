//Question link
//https://www.geeksforgeeks.org/problems/generalised-fibonacci-numbers1820/1

public class GenFibNum {
    
    static long[][] mat;
    static long[][] res;

    private static void multiply(long[][] res, long[][] mat, long m) {
        long[][] res1 = new long[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    res1[i][j] += (res[i][k] * mat[k][j]) % m;
                    res1[i][j] %= m;
                }
            }
        }
        for (int i = 0; i < 3; ++i) {
            System.arraycopy(res1[i], 0, res[i], 0, 3);
        }
    }

    private static void matrixExponentiation(long n, long m) {
        while (n > 0) {
            if ((n & 1) == 1) {
                multiply(res, mat, m);
            }
            multiply(mat, mat, m);
            n /= 2;
        }
    }

    static long genFibNum(long a, long b, long c, long n, long m) {
        res = new long[3][3];
        res[0][0] = res[1][1] = res[2][2] = 1;

        mat = new long[3][3];
        mat[0][0] = a;
        mat[0][1] = b;
        mat[0][2] = mat[1][0] = mat[2][2] = 1;
        mat[1][1] = mat[1][2] = mat[2][0] = mat[2][1] = 0;

        if (n <= 2) {
            return 1 % m;
        } else {
            matrixExponentiation(n - 2, m);
            return (res[0][0] + res[0][1] + c * res[0][2]) % m;
        }
    }

    public static void main(String[] args) {
        long a = 1, b = 1, c = 1;
        long n = 5, m = 1000000007;
        System.out.println(genFibNum(a, b, c, n, m));
    }

}
