class Solution {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length, i = 0, j = 0, k = n - 1;
        while(j <= k){
            if(nums[j] == 0){
                swap(nums, i, j);
                i++;
                j++;
            }
            else if(nums[j] == 2){
                swap(nums, j , k);
                k--;
            }
            else{
                j++;
            }
        }
    }
}
        // int c0 = 0, c1 = 0, c2 = 0;
        // for(int n : nums){
        //     if(n == 0){
        //         c0++;
        //     }
        //     else if(n == 1){
        //         c1++;
        //     }
        //     else{
        //         c2++;
        //     }
        // }
        // int i = 0;
        // while(i < nums.length){
        //     int j = 0;
        //     while(j < c0){
        //         nums[i++] = 0; 
        //         j++;
        //     }
        //     j = 0;
        //     while(j < c1) {
        //         nums[i++] = 1;
        //         j++;
        //     }
        //     j = 0;
        //     while(j < c2) {
        //         nums[i++] = 2;
        //         j++;
        //     }
        // }
