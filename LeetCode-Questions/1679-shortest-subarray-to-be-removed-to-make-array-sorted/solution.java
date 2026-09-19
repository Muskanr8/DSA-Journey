class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int i = 0;
        while(i < n - 1 && arr[i] <= arr[i + 1]){
            i++;
        }

        if(i == n - 1) return 0;

        int j = n - 1;
        while(j > 0 && arr[j - 1] <= arr[j]){
            j--;
        }

        int result = Math.min(n - i - 1, j);

        int left = 0, right = j;

        while(left <= i && right < n){
            if(arr[left] <= arr[right]){
                result = Math.min(result, right - left - 1);
                left++;
            }
            else{
                right++;
            }
        }

        return result;
    }
}
