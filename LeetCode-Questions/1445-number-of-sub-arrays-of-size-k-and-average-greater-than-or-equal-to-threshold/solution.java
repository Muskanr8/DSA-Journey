class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int count = 0;

        if (windowSum >= k * threshold) {
            count++;
        }

        for (int i = k; i < nums.length; i++) {

            windowSum += nums[i];
            windowSum -= nums[i - k];

            if (windowSum >= k * threshold) {
                count++;
            }
        }

        return count;
    }
}
