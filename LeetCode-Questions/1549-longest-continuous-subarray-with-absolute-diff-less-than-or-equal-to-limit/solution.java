class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int left = 0, answer = 0;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        for(int right = 0; right < nums.length; right++){

            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]){
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while((nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()]) > limit){

                left++;

                while(!maxDeque.isEmpty() && maxDeque.peekFirst() < left){
                    maxDeque.pollFirst();
                }

                while(!minDeque.isEmpty() && minDeque.peekFirst() < left){
                    minDeque.pollFirst();
                }
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
