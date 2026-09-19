class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int t = x, rev = 0;
        while(t > 0){
            rev = rev * 10 + (t % 10);
            t /= 10;
        }
        if(x == rev){
            return true;
        }
        return false;
    }
}
