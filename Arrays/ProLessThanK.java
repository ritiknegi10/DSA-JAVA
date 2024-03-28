//question link https://leetcode.com/problems/subarray-product-less-than-k/description/?envType=daily-question&envId=2024-03-27
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int s = 0, e = 0, prod = 1, ans = 0;
        while(e < nums.length) {
            prod *= nums[e++]; // include
            while(s < e && prod >= k) {
                prod /= nums[s++]; // exclude start
            }
            if(prod < k) {
                ans += e-s; // add to answer if it is valid
            }
        }
        return ans;
    }
}