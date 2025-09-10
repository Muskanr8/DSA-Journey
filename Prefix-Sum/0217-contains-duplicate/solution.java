class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();

        for(int n = 0; n < nums.length; n += 1){
            if(freq.contains(nums[n]))
                return true;
            freq.add(nums[n]);
        }

        return false;
    }
}
