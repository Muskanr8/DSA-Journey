class Solution {
    public int balancedString(String s) {

        int[] count = new int[128];

        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int target = s.length() / 4;

        if (count['Q'] == target &&
            count['W'] == target &&
            count['E'] == target &&
            count['R'] == target) {
            return 0;
        }

        int left = 0;
        int minLen = s.length();

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right)]--;

            while (left <= right &&
                   count['Q'] <= target &&
                   count['W'] <= target &&
                   count['E'] <= target &&
                   count['R'] <= target) {

                minLen = Math.min(minLen, right - left + 1);

                count[s.charAt(left)]++;
                left++;
            }
        }

        return minLen;
    }
}
