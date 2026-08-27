class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        final long MOD = 1_000_000_007L;
        long ans = 0;

        for(int i = 0; i < arr.length - 2; i++){
            int l = i + 1, r = arr.length - 1;
            while(l < r){
                int sum = arr[i] + arr[l] + arr[r];

                if(sum < target){
                    l++;
                }
                else if(sum > target){
                    r--;
                }
                else{
                    if(arr[l] != arr[r]){
                        int lc = 1, rc = 1;
                        while(l + 1 < r && arr[l] == arr[l + 1]){
                            lc++;
                            l++;
                        }
                        while(l < r - 1 && arr[r] == arr[r - 1]){
                            rc++;
                            r--;
                        }

                        ans += lc * rc;
                        ans %= MOD;

                        l++;
                        r--;
                    }
                    else{
                        int n = r - l + 1;
                        ans += n * (n - 1) / 2;
                        ans %= MOD;

                        break; 
                    }
                }
            }
        }
        return (int) ans;
    }
}
