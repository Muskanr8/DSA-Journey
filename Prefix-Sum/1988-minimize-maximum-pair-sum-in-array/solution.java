class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0, j = n - 1, max = 0;
        while(i < j){
            int sum = nums[i] + nums[j];
            max = Math.max(max, sum);
            i++;
            j--;
        }
        return max;
    }
}
