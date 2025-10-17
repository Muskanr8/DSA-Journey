class Solution {
    public int maxSubArray(int[] nums) {
        int crr = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i += 1){
            if(crr < 0)
                crr = 0;
            crr += nums[i];
            max = Math.max(crr, max);
        }
        return max;
    }
}
