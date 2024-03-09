//Question Link
//https://www.geeksforgeeks.org/problems/find-the-n-th-character5925/1

package Strings;

public class FindNthChar {
    

    public char nthCharacter(String s, int r, int n)
    {
        //code here
    
        for(int i =0; i< r; i++){
            StringBuilder str = new StringBuilder();
            for(int j =0; j< s.length(); j++){
                if(s.charAt(j) == '0') str.append("01");
                else str.append("10");
            }
            s = str.toString().substring(0,n+1);
        }
        return s.charAt(n);
    }

}
