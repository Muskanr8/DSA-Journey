class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        int[] visit = new int[1001];
        int[] temp = new int[1001];
        int count = 0;

        for(int i = 0; i < nums1.length; i++){
            visit[nums1[i]] = 1;
        }

        for(int i = 0; i < nums2.length; i++){

            if(visit[nums2[i]] == 1){
                temp[count++] = nums2[i];
                visit[nums2[i]] = 2;
            }
        }

        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i] = temp[i];
        }

        return result;
    }
}
