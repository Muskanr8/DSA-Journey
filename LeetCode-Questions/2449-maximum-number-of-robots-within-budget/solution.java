class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

        int left = 0;
        long sum = 0;
        int answer = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < chargeTimes.length; right++) {

            // 1. Add running cost
            sum += runningCosts[right];

            // 2. Maintain decreasing deque
            while (!deque.isEmpty() &&
                   chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            // 3. Shrink while cost is invalid
            while (!deque.isEmpty() &&
                   chargeTimes[deque.peekFirst()]
                   + (long)(right - left + 1) * sum > budget) {

                sum -= runningCosts[left];
                left++;

                // 4. Remove expired index
                while (!deque.isEmpty() &&
                       deque.peekFirst() < left) {
                    deque.pollFirst();
                }
            }

            // 5. Current window is valid
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
