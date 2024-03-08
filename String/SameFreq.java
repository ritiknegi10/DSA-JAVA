//problem Link
//https://www.geeksforgeeks.org/problems/check-frequencies4211/1

package String;
import java.util.*;
class sameFreq {
    public boolean sameFrequency(String s) {
        // Count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Count the frequency counts
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);
        }
        
        // If there is only one frequency count, all characters have the same frequency
        if (countMap.size() == 1) {
            return true;
        }
        
        // If there are two frequency counts, check if one count is only one greater than the other
        if (countMap.size() == 2) {
            int[] counts = countMap.keySet().stream().mapToInt(Integer::intValue).toArray();
            int smallerCount = Math.min(counts[0], counts[1]);
            int largerCount = Math.max(counts[0], counts[1]);
            if (smallerCount == 1 && countMap.get(smallerCount) == 1) {
                return true;
            }
            if (countMap.get(largerCount) == 1 && largerCount - smallerCount == 1) {
                return true;
            }
        }
        
        // Otherwise, it's not possible
        return false;
    }
}