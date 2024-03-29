// question link https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29

import java.util.List;

public class SubarrayWithMaxEle {

    long count = 0;

    private boolean isValid(List<Integer> list, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i))
                cnt++;
        }
        return cnt >= k;
    }

    private void solveRec(int[] nums, int idx, int k, List<Integer> list) {
        // Base Case
        if (idx >= nums.length) {
            if (isValid(list, k)) {
                count++;
                return;
            }
            return;
        }

        // take it
        list.add(nums[idx]);
        solveRec(nums, idx + 1, k, list);
        list.remove(list.size() - 1);

        // nontake it
        solveRec(nums, idx + 1, k, list);

    }



    //Drive Code
    public long countSubarrays(int[] nums, int k) {
        // solveRec(nums, 0, k, new ArrayList<>());
        // return count;




        // getting the maximum element
        // int max = Arrays.stream(nums).max().getAsInt();
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // to store the count of subarray with min "k" number repeat of maximum
        long count = 0;
        int idx = 0, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i] == max ? 1 : 0;

            while (curr >= k) {
                curr -= nums[idx++] == max ? 1 : 0;
            }
            count += idx;
        }
        return count;

    }

}
