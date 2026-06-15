class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 1, n = arr.length;
        for(int j = 1; j < n; j += 1){
            if(arr[j] != arr[j - 1]){
                arr[i] = arr[j];
                i += 1;
            }
        }
        return i;
    }
}
