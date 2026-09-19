class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int goal){

        if (goal < 0) {
            return 0;
        }   

        int oddCount = 0, l = 0, count = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] % 2 != 0) oddCount++;

            while(oddCount > goal){
                if (nums[l] % 2 != 0) {
                    oddCount--;
                }
                l++;
            }

            count += r - l + 1;
        }

        return count;
    }
}
