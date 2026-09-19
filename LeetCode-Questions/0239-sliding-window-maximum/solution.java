class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // 1. Create a Deque to store indices.
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        // 2. Traverse the array.
        for(int i = 0; i < nums.length; i++){

        // 3. For every right:
        
            // Remove indices from the back while their values are <= nums[i].
            //They are smaller/equal, so they can never become the maximum.
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            //Add i to the back.
            deque.offerLast(i);

            //Find the current window's starting index:
            int start = i - k + 1;

            //If the front index is smaller than start, remove it from the front because it has expired.
            if(deque.peekFirst() < start){
                deque.pollFirst();
            }

            // 4. Once i >= k - 1, the window has at least k elements.
            if(i >= k - 1){

                // The front of the deque contains the maximum element's index.
                // Add nums[deque.peekFirst()] to the answer.
                ans[index++] = nums[deque.peekFirst()];
            }
        }    

        return ans;
    }
}
