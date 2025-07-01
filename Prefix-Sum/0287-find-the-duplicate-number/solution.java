class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n + 1];

        for(int i = 0; i < n; i += 1){
            frequency[nums[i]] += 1;
            if(frequency[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }
}
