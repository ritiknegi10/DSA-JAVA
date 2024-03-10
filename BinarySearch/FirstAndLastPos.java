//Question Link
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};

        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }
    int search(int[] letters, int target , boolean findStartIndex){
        int ans =-1;
        int start = 0;
        int end = letters.length - 1;

        while(start <= end) {
            
            int mid = start + (end - start) / 2;

            
                if (target < letters[mid]) {
                    end = mid - 1;
                } else if (target > letters[mid]){
                    start = mid + 1;
                }
            else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}