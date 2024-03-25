//Que : Given a positive integer N, the task is to find the Nth bit of the binary representation of N.
//Link to question: https://practice.geeksforgeeks.org/problems/print-nth-bit4140/1

package String;

import java.util.ArrayList;

public class PrintNthBit {
  
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int ones = 0;
        int zeros = 0;
        String op = "";
        solve(ones, zeros, N, op,res);
        return res;
    }
    
    public void solve(int ones, int zeros, int N, String op, ArrayList<String> res) {
        if (N == 0) {
            res.add(op);
            return;
        }
        
        String op1 = op;
        op1 += "1";
        solve(ones + 1, zeros, N - 1, op1, res);
        
        if (ones > zeros) {
            String op2 = op;
            op2 += "0";
            solve(ones, zeros + 1, N-1, op2, res);
        }
        
        return;
    
}
}
