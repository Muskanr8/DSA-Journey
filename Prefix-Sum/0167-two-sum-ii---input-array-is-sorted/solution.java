class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
        int[] result = {-1, -1};
        
        while(i < j){
            // int sum = numbers[i] + numbers[j];
            if(numbers[i] + numbers[j] == target){
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            else if(numbers[i] + numbers[j] < target){
                i += 1;
            }
            else{
                j -= 1;
            }
        }
    return result;
    }
}
