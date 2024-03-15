//Quesion link
//https://www.codingninjas.com/studio/problems/subarrays-with-xor-k_6826258?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM
import java.util.HashMap;
public class XOR {

 



    public static int subarraysWithSumK(int []a, int b) {

        // Write your code here

        int n = a.length;

        HashMap<Integer,Integer> mpp = new HashMap<>();

        int xor =0, count =0;

        mpp.put(0,1);

        for(int i=0;i<n;i++){

            xor ^= a[i];

            int x = xor^b;

            if(mpp.containsKey(x)) count += mpp.getOrDefault(x,0);

            if(mpp.containsKey(xor)){

                int val = mpp.getOrDefault(xor,0);

                mpp.put(xor,val+1);

            }else mpp.put(xor,1);

        }

        return count;

    }


}
