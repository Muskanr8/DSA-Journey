class Solution {
    public long minimumSteps(String s) {
        long swaps = 0, blacks = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                swaps += blacks;
            }
            else{
                blacks++;
            }
        }
        return swaps;
    }
}
