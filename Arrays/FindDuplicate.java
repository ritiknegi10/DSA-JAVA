//Question link
//link:https://leetcode.com/problems/find-the-duplicate-number/?envType=daily-question&envId=2024-03-24
package Arrays;

public class FindDuplicate {
    
        public int findDuplicate(int[] nums) {
            // Floyd's Tortoise and Hare (Cycle Detection) algorithm
            int slow = nums[0];
            int fast = nums[0];
            
            // Finding the intersection point of slow and fast pointers
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            
            // Finding the entrance to the cycle
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            
            return slow;
        }
     
}
