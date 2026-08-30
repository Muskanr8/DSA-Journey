class Solution {
    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        long[] power = new long[nums.length];

        power[0] = 1;

        int MOD = 1_000_000_007;
        
        for(int i = 1; i < nums.length; i++){
            power[i] = (power[i - 1] * 2) % MOD;
        }

        int i = 0, j = nums.length - 1, count = 0;

        while(i <= j){

            if(nums[i] + nums[j] <= target){

                count += power[j - i];
                count %= MOD;
                i++;
            }
            else{

                j--;
            }
        }

        return (int) count;
    }
}
