class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int rightSum = 0, leftSum = 0, i = 0;

        for(int n : nums){
            rightSum += n;
        }

        int[] answer = new int[nums.length];

        for(int n : nums){

            rightSum -= n;
            answer[i++] = Math.abs(leftSum - rightSum);
            leftSum += n;
        }

        return answer;
    }
}