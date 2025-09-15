class Solution {
    public int findDuplicate(int[] nums) {

        int n = nums.length;
        int[] frequency = new int[n + 1];

        for(int i = 0; i < n; i += 1){
            frequency[nums[i]] += 1;
            if(frequency[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }
}
        // HashSet<Integer> freq = new HashSet<>();
        // int found = 0;
        // for(int num : nums){
        //     if(freq.contains(num)){
        //         found = num;
        //     }
        //     else{
        //         freq.add(num);
        //     }
        // }
        // return found;
