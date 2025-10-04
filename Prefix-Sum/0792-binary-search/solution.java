class Solution {
    public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
        int middle = low + (high - low) / 2;
        int value = nums[middle];

        if (value < target) {
            low = middle + 1;
        } else if (value > target) {
            high = middle - 1;
        } else {
            return middle;  // target found
        }
    }
    return -1;
    }
}
