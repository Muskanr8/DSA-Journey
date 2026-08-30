class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);

        long answer = countPairs(nums, upper) - countPairs(nums, lower - 1);

        return answer;
    }

    private long countPairs(int[] nums, int limit){
        long count = 0;

        int i = 0, j = nums.length - 1;
        
        while(i < j){

            if(nums[i] + nums[j] <= limit){

                count += j - i;
                i++;
            }
            else{

                j--;
            }
        }

        return count;
    }
}
        // int count = 0;
        // for(int i = 0; i < nums.length - 1; i++){

        //     int j = i + 1;
        //     while(j < nums.length){

        //         if(lower <= nums[i] + nums[j] && nums[i] + nums[j] <= upper)
        //             count++;

        //         j++;
        //     }
        // }

        // return count;
