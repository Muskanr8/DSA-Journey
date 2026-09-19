class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = s.length()-1;

        while(i <= j){
            if(str[i] != 'A' && str[i] != 'E' && str[i] != 'I' && str[i] != 'O' && str[i] != 'U' && str[i] != 'a' && str[i] != 'e' && str[i] != 'i' && str[i] != 'o' && str[i] != 'u'){
                i++;
            }
            else if(str[j] != 'A' && str[j] != 'E' && str[j] != 'I' && str[j] != 'O' && str[j] != 'U' && str[j] != 'a' && str[j] != 'e' && str[j] != 'i' && str[j] != 'o' && str[j] != 'u'){
                j--;
            }
            else{
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;

                i++;
                j--;
            }
        }

        return new String(str);
        // StringBuilder str = new StringBuilder(s);
        // s = s.toLowerCase();
        // while(i <= j){
        //     if(s.charAt(i) != 'a'&& s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u'){
        //         i++;
        //     }
        //     else if(s.charAt(j) != 'a'&& s.charAt(j) != 'e' && s.charAt(j) != 'i' && s.charAt(j) != 'o' &&  s.charAt(j) != 'u'){
        //         j--;
        //     }
        //     else{
        //         char ch = str.charAt(i);
        //         str.setCharAt(i, str.charAt(j));
        //         str.setCharAt(j, ch);

        //         i++;
        //         j--;
        //     }
        // }

        // return str.toString();
    }
}
