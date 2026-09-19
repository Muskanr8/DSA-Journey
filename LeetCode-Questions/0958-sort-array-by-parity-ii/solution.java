class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1;
        int[] res = new int[nums.length];
        for(int n : nums){
            if(n % 2 == 0){
                res[i] = n;
                i+=2;
            }
            else{
                res[j] = n;
                j+=2;
            }
        }
        return res;
    }
}

