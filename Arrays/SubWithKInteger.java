// Find the number of subarrays with exactly k distinct elements
//LINK: https://leetcode.com/problems/subarrays-with-k-distinct-integers/
package Arrays;

public class SubWithKInteger {


    // Main method to find the number of subarrays with exactly k distinct elements
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Find the number of subarrays with at most k distinct elements
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        // Find the number of subarrays with at most (k - 1) distinct elements
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        // The difference between the two gives the number of subarrays with exactly k distinct elements
        return subWithMaxK - reducedSubWithMaxK;
    }
    
    // Helper method to find the number of subarrays with at most k distinct elements
    public int subarrayWithAtMostK(int[] nums, int k) {
        // HashMap to store the count of each element in the current window
        HashMap<Integer, Integer> map = new HashMap<>();
        // Pointers to track the current window
        int left = 0, right = 0;
        // Variable to store the count of subarrays satisfying the condition
        int ans = 0;
        
        // Expand the window to the right until it reaches the end of the array
        while (right < nums.length) {
            // Include the current element in the window and update its count in the map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            // If the number of distinct elements in the window exceeds k, shrink the window from the left
            while (map.size() > k) {
                // Decrease the count of the element at the left pointer
                map.put(nums[left], map.get(nums[left]) - 1);
                // If the count becomes 0, remove the element from the map
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                // Move the left pointer to the right
                left++;
            }
            
            // Count the subarrays ending at the current right pointer and add it to the answer
            // The number of subarrays is equal to the size of the window (right - left + 1)
            ans += right - left + 1; // Size of subarray
            // Move the right pointer to the right
            right++;
        }
        
        // Return the total count of subarrays satisfying the condition
        return ans;
    }

}
