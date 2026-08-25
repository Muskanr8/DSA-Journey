class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //1. Initialize result array
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        //2. Check for edge case
        if(nums.length < 3){
            return res;
        }

        //3. Sort the Array
        Arrays.sort(nums);

        //4. Iterate through Array
        for(int i = 0; i < n - 2; i += 1){
            //4.1 Skip duplicates for 1st element
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            //4.2 Early Stoppage, if the number is positive
            if(nums[i] > 0) break;

            //4.3 Initialize the two pointers
            int j = i + 1, k = n - 1;

            //4.4 Set target for twoo pointers sum
            int target = -nums[i];

            //4.5 Scan the two pointers
            while(j < k){
                int sum = nums[j] + nums[k];
                //4.5.1 if sum is found;
                if(sum == target){
                    //4.5.1.1 Add it to result and move further
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    //4.5.1.2 Skip the duplicates
                    while((j < k) && nums[j] == nums[j - 1]) j++;
                    while((j < k) && nums[k] == nums[k + 1]) k--; 
                }

                //4.5.2 Sum < target; need larger sum -> j++
                else if(sum < target){
                    j++;
                }

                //4.5.3 sum > target; need smaller sum -> k--
                else{
                    k--;
                }
            } 
        }

        //5. Return the result
        return res;
    }
}
