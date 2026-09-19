class Solution {
    public int maximumLengthSubstring(String s) {
        
        int l = 0, maxLen = 0;
        int[] freq = new int[26];
        for(int r = 0; r < s.length(); r++){

            freq[s.charAt(r) - 'a']++;
            while(freq[s.charAt(r) - 'a'] > 2){
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
