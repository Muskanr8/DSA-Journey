class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] need = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            need[ch - 'a']++;
        }

        int l = 0;

        for (int r = 0; r < s2.length(); r++) {

            // 1. Add current character
            window[s2.charAt(r) - 'a']++;

            // 2. If window becomes too large, remove left character
            if (r - l + 1 > s1.length()) {
                window[s2.charAt(l) - 'a']--;
                l++;
            }

            // 3. If window size matches s1
            if (r - l + 1 == s1.length()) {

                // 4. Compare frequencies
                if (Arrays.equals(need, window)) {
                    return true;
                }
            }
        }

        return false;
    }
}
