class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        for(int n : nums){
            if(n % 2 == 0){
                res[i] = n;
                i++;
            }
            else{
                res[j] = n;
                j--;
            }
        }
        return res;
    }
}
