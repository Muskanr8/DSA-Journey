class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0, n = tokens.length, i = 0, j = n - 1;
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i];
                score++;
                i++;
                maxScore = Math.max(score, maxScore);
            }
            else if(score > 0){
                power += tokens[j];
                score--;
                j--;
            }
            else{
                break;
            }
        }
        return maxScore;
    }
}
