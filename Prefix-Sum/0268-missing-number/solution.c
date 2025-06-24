int missingNumber(int* nums, int numsSize) {
    int sum1 = 0;
    int sum2 = 0;
    
    for(int i = 0; i <= numsSize; i += 1){
        sum1 += i;
    }
    for(int i = 0; i < numsSize; i += 1){
        sum2 += nums[i];
    }
    
    return sum1 - sum2;
    
}
