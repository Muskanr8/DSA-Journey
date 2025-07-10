class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
      int i = 0;
      int j = 0;
      int k = 0;
      int[] res = new int[n + m];

      while(i < n && j < m){
        if(nums1[i] < nums2[j]){
            res[k] = nums1[i];
            i += 1;
        }
        else{
            res[k] = nums2[j];
            j += 1;
        }
        k += 1;
      }

      while(i < n){
        res[k] = nums1[i];
        i += 1;
        k += 1;
      }

      while(j < m){
        res[k] = nums2[j];
        j += 1;
        k += 1;
      }

      for (int p = 0; p < m + n; p++) 
        nums1[p] = res[p];
    }
}
