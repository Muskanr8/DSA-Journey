class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] res = new int[2];
        int i = 0, j = n - 1;
        while(i <= j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }
            else if(sum > target){
                j -= 1;
            }
            else{
                i += 1;
            }
        }
        return res;
    }
}
