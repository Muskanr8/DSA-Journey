class Solution {
    public void moveZeroes(int[] arr) {
        int i = 0, n = arr.length;
        for(int j = 0; j < n; j += 1){
            if(arr[j] != 0){
                arr[i] = arr[j];
                i += 1;
            }
        }
        while(i < n){
            arr[i] = 0;
            i += 1;
        }
    }
}
