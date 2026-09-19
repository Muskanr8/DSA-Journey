class Solution {
    public int compress(char[] chars) {
        int j = 0, n = chars.length;
        for(int i = 0; i < n;){
            char letter = chars[i];
            int c = 0;

            while(i < n && chars[i] == letter){
                c++;
                i++;
            }

            chars[j] = letter;
            j++;

            if(c > 1){
                char[] nums = String.valueOf(c).toCharArray();
                for(char ch : nums){
                    chars[j] = ch;
                    j++;
                }
            }
        }
        return j;
    }
}
