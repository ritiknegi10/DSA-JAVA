//Question: Sort characters by frequency of occurrence
//link: https://leetcode.com/problems/sort-characters-by-frequency/
package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFreq {
    
    public String frequencySort(String s) {
        // Create a map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each character in the string
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        // Create a list of unique characters
        List<Character> uniqueChars = new ArrayList<>(frequencyMap.keySet());
        
        // Sort the list of characters based on their frequency
        uniqueChars.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        // Build the sorted string
        StringBuilder sortedString = new StringBuilder();
        for (char ch : uniqueChars) {
            int frequency = frequencyMap.get(ch);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(ch);
            }
        }
        
        return sortedString.toString();
    }

}
