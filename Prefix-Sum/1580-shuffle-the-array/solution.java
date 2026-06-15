class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i += 1){
            x[i] = nums[i];
            y[i] = nums[i + n];
        }
        int[] ans = new int[2 * n];
        int a = 0, b = 0;
        for(int i = 0; i < 2 * n; i += 1){
            if(i % 2 == 0){
                ans[i] = x[a];
                a += 1;
            }
            else{
                ans[i] = y[b];
                b += 1;
            }
        }
        return ans;
    }
}
