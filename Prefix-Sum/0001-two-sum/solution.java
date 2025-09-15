class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length - 1; i += 1){
            for(int j = i + 1; j < nums.length; j += 1){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
}

// for(int i = 0; i < numsSize - 1; i += 1){
//         for(int j = i + 1; j < numsSize; j += 1){
//             if(nums[i] + nums[j] == target){
               
//                 result[0] = i;
//                 result[1] = j;
//                 return result;
//             } 
//         }
//     }
//     return 0;
