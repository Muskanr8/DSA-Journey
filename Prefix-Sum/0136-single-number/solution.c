int singleNumber(int* nums, int numsSize) {
    int xor = 0;

    for(int i = 0; i < numsSize; i += 1){
        xor ^= nums[i];
    }

    return xor;
}
// TC: O(n)
