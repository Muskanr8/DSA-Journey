class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        Integer[] indices = new Integer[nums2.length];
        for(int i = 0; i < nums2.length; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> nums2[a] - nums2[b]);

        int left = 0, right = nums1.length - 1;

        int[] ans = new int[nums1.length];

        for(int i = nums2.length - 1; i >= 0; i--){
            int index = indices[i];

            if(nums1[right] > nums2[index]){
                ans[index] = nums1[right];
                right--;
            }
            else{
                ans[index] = nums1[left];
                left++;
            }
        }

        return ans;
    }
}
