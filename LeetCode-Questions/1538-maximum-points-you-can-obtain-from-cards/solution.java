class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int total = 0;
        for (int num : cardPoints) {
            total += num;
        }

        int windowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int ans = total - windowSum;

        for (int i = windowSize; i < n; i++) {

            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];

            ans = Math.max(ans, total - windowSum);
        }

        return ans;
    }
}
