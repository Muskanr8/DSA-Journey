class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1, max = 0;
        while(i < j){
            int w = j - i;
            int h = Math.min(arr[i], arr[j]);
            int a = w * h;
            if(a > max){
                max = a;
            }
            if(arr[i] < arr[j])
                i += 1;
            else
                j -= 1;
        }
        return max;
    }
}
