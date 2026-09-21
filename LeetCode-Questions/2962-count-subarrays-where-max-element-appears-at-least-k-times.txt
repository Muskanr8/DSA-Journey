class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int max = nums[0];
        for(int n : nums){
            if(n > max) max = n;
        }

        List<Integer> positions = new ArrayList<>();
        long lastK = -1, count = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == max){
                positions.add(i);
            }

            if(positions.size() >= k){
                lastK = positions.get(positions.size() - k);
                count += lastK + 1;
            }
        }

        return count;
    }
}
