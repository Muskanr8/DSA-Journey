class Solution {
    public int minOperations(int[] nums, int x) {
        
        int minLen = 0, currSum = 0, l = 0;
        int sum = 0;
        for (int num : nums) sum += num;
        int target = sum - x;

        if (target == 0) return nums.length;

        for(int r = 0; r < nums.length; r++){

            currSum += nums[r];

            while(l <= r && currSum > target){
                currSum -= nums[l];
                l++;
            }

            if(currSum == target){
                minLen = Math.max(minLen, r - l + 1);
            }
        }

        return minLen != 0 ? nums.length - minLen : -1;
    }
}
