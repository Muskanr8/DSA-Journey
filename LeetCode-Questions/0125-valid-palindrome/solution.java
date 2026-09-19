class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int i = 0, j = s.length() - 1;

        if(s.isEmpty()){
            return true;
        }

        while(i < j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else{
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
}
