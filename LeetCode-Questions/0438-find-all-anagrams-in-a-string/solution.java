class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] need = new int[26];
        int[] window = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            need[ch - 'a']++;
        }

        int l = 0;

        for (int r = 0; r < s.length(); r++) {

            // 1. Add current character
            window[s.charAt(r) - 'a']++;

            // 2. If window becomes too large, remove left character
            if (r - l + 1 > p.length()) {
                window[s.charAt(l) - 'a']--;
                l++;
            }

            // 3. If window size matches s1
            if (r - l + 1 == p.length()) {

                // 4. Compare frequencies
                if (Arrays.equals(need, window)) {
                    ans.add(l);
                }
            }
        }

        return ans;
    }
}
