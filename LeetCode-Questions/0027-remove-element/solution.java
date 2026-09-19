class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length;){
            if(nums[j] == val){
                j++;
            }
            else{
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
