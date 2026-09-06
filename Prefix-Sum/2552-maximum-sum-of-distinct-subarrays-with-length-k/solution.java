class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        long windowSum = 0, maxSum = 0;

        for(int i = 0; i < k; i++){
            windowSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if(map.size() == k) maxSum = Math.max(windowSum, maxSum);

        for(int i = k; i < nums.length; i++){

            windowSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            windowSum -= nums[i - k];
            map.put(nums[i-k], map.get(nums[i-k]) - 1);

            if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);

            if(map.size() == k) maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}
