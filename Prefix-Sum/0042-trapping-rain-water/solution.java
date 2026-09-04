class Solution {
    public int trap(int[] arr) {
        
        int n = arr.length;
        int i = 0, j = n - 1;
        int iMax = arr[i], jMax = arr[j];
        int res = 0;

        while(i < j){

            //Process left
            if(arr[i] <= arr[j]){

                i++;
                iMax = Math.max(arr[i], iMax);
                res += iMax - arr[i];
            }
            //Process right
            else{
                
                j--;
                jMax = Math.max(arr[j], jMax);
                res += jMax - arr[j];
            }
        }
        return res;
    }
}
