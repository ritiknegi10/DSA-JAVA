//question Link
//https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/?envType=daily-question&envId=2024-03-05

package Strings;
import java.util.*;

class MinLengthOfStr {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }

            char ch = s.charAt(left);
            while (left < right && s.charAt(left) == ch)
                left++;
            while (right >= left && s.charAt(right) == ch)
                right--;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        MinLengthOfStr solution = new MinLengthOfStr();
        
        // Randomly generated string
        String testString = "abcaedcba"; 
        
        // Calculate minimum length
        int minLength = solution.minimumLength(testString);
        
        // Output the result
        System.out.println("Minimum length after operations: " + minLength);
    }
}