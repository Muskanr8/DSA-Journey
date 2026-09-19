class Solution {
    public long countSubarrays(int[] nums, long k) {

        int left = 0;
        long sum = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            // 1. Add right element
            sum += nums[right];

            // 2. Shrink while score is invalid
            while (sum * (right - left + 1L) >= k) {
                sum -= nums[left];
                left++;
            }

            // 3. Count valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
