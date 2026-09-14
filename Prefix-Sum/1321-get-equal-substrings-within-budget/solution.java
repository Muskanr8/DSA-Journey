class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int l = 0, maxLen = 0, cost = 0;

        for(int r = 0; r < s.length(); r++){

            cost += Math.abs(s.charAt(r) - t.charAt(r));

            if(cost > maxCost){

                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            } 

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
