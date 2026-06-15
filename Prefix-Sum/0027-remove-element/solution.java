class Solution {
    public int removeElement(int[] arr, int val) {
        int i = 0, n = arr.length;
        for(int j = 0; j < n; j += 1){
            if(arr[j] != val){
                arr[i] = arr[j];
                i += 1;
            }
        }
        return i;
    }
}
