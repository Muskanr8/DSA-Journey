class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        int j = 0;
        for(int i = 0; i < n; i += 1){
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
