class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        if (s.isEmpty()) {
            return true;
        }
        while (i < j) {

            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {

                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }

                i++;
                j--;
            }
        }
        return true;
    }
}
