class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int slen = s.length();
        int tlen = t.length();
        if(slen != tlen){
            return false;
        }
        for(int i = 0; i < slen; i += 1){
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            freq[ch - 'a'] += 1;
            freq[ch1 - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i += 1){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
}
        // char[] string1 = s.toCharArray();
        // char[] string2 = t.toCharArray();

        // Arrays.sort(string1);
        // Arrays.sort(string2);

        // return Arrays.equals(string1, string2);

//Time Complexity : O(N log N)
//Space Complexity : O(N)
