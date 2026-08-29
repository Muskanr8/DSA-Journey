class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 0, c = 0;
        while(i < nums.length && j < nums.length){
            if(nums[j] > nums[i]){
                c++;
                i++;
            }
            j++;
        }
        return c;
    }
}
