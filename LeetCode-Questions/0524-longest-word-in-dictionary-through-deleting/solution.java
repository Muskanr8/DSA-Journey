class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String answer = "";

        for(String word : dictionary){

            if(isSubsequence(s, word)){

                if(word.length() > answer.length() || 
                  (word.length() == answer.length()
                  && word.compareTo(answer) < 0)){

                    answer = word;
                }
            }
        }

        return answer;
    }
    
   private boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;

        while(i < s.length() && j < t.length()){

            if(s.charAt(i) == t.charAt(j)){
                j++;
            }

            i++;
        }

        if(j == t.length()){
            return true;
        }
        return false;
    }
}

