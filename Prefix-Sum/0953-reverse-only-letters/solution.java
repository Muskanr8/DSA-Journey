class Solution {
    public String reverseOnlyLetters(String str) {
        char[] s = str.toCharArray();

        int i = 0, j = str.length() - 1;

        while(i <= j){
            if(!Character.isLetter(s[i])){
                i++;
            }
            else if(!Character.isLetter(s[j])){
                j--;
            }
            else{
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;

                i++;
                j--;
            }
        }

        return new String(s);
    }
}
