class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int m = accounts[0].length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i += 1){
            int rowSum = 0;
            for(int j = 0; j < m; j += 1){
                rowSum += accounts[i][j];
            }
            if(max < rowSum){
                max = rowSum;
            }
        }
        return max;
    }
}
