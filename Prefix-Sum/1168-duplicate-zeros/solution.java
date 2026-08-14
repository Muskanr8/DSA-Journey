class Solution {
    public void duplicateZeros(int[] arr) {
        int c = 0, n = arr.length, i = n - 1;
        for(int x : arr){
            if(x == 0){
                c++;
            }
        }
        int j = n + c - 1;

        while(i >= 0){
            if(j < n){
                arr[j] = arr[i];
            }
            if(arr[i] == 0){
                j--;
                if(j < n){
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }
}
