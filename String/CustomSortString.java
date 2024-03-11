//Question Link
//https://leetcode.com/problems/custom-sort-string/?envType=daily-question&envId=2024-03-11

package String;

public class CustomSortString {
    
import java.util.HashMap;
import java.util.Map;


    public String customSortString(String order, String s) {
        // Step 1: Initialize character count map
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build result string based on the specified order
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                while (count > 0) {
                    result.append(c);
                    count--;
                }
                charCount.remove(c); // Remove processed character to avoid duplication
            }
        }

        // Step 3: Append remaining characters not present in the specified order
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                result.append(c);
                count--;
            }
        }

        // Step 4: Return the final result as a string
        return result.toString();
    }

}
