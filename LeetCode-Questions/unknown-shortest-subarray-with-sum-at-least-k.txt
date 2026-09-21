class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for(int i = 0; i < prefix.length - 1; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);

        int ans = Integer.MAX_VALUE;

        for(int right = 1; right < prefix.length; right++){

            while (!deque.isEmpty() &&
                    prefix[right] - prefix[deque.peekFirst()] >= k) {

                ans = Math.min(ans, right - deque.peekFirst());

                deque.pollFirst();
            }

            while (!deque.isEmpty() &&
                    prefix[deque.peekLast()] >= prefix[right]) {

                deque.pollLast();
            }

            deque.offerLast(right);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
