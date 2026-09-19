class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //1. Initialize a list of result
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        //2. Edge Case
        if(n < 4 || nums == null) return res;

        //3. Sort the array
        Arrays.sort(nums);

        //4. Iterate through array:
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int x = j + 1; int y = n - 1;
                while(x < y){
                    long sum = (long)nums[i] + nums[j] + nums[x] + nums[y];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                        
                        while((x < y) && nums[x] == nums[x + 1]) x++;
                        while((x < y) && nums[y] == nums[y - 1]) y--;

                        x++;
                        y--;
                    }
                    else if(sum < target) x++;
                    else y--;
                }
            }
        }

        //5. Return results
        return res;
    }
}
