class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        int i = 0;
        int temp;
        while(j < n && i < n){
            if(nums[j] != 0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 1;
            }
            j += 1;
        }
    }
}
