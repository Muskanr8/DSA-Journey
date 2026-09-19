class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = (n * (n + 1)) / 2;

        for(int i = 0; i < nums.length; i += 1){
            sum1 -= nums[i];
        }
        return sum1;
    }
}
