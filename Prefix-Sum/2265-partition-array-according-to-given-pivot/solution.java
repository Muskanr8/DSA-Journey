class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i = 0, j = nums.length - 1;
        int l = 0, r = nums.length - 1;

        int[] ans = new int[nums.length];

        while(i < nums.length){
            if(nums[i] < pivot){
                ans[l++] = nums[i];
            }
            if(nums[j] > pivot){
                ans[r--] = nums[j];
            }
            i++;
            j--;
        }

        while(l <= r){
            ans[l++] = pivot;
        }
        
        return ans;
    }
}
