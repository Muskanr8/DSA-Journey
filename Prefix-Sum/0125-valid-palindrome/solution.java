class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i += 1){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                str.append(ch);
            }
            else if(ch >= '0' && ch <= '9'){
                str.append(ch);
            }
        }

        int i = 0; 
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}
// Time Complexity = O(n)
// Space Complexity = O(n)
