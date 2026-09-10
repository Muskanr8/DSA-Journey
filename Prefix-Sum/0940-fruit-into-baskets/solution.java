class Solution {
    public int totalFruit(int[] fruits) {

        int prev = -1, secPrev = -1, prevCount = 0, currLen = 0, maxLen = 0;
        for(int i = 0; i < fruits.length; i++){

            int curr = fruits[i];

            // Check the current fruit
            if(curr == prev || curr == secPrev){

                // If the fruit is same as last 2 fruits, extend the window length
                currLen++;
            }
            else{
                
                // else reset window length to previous fruit count
                currLen = prevCount + 1;
            }

            // Moving forward and updating fruits
            if(curr == prev){

                // If the fruit is same as previous, extend the window
                prevCount++;
            }
            else{

                // update the fruit if it's a new type as second previous fruit
                prevCount = 1;
                secPrev = prev;
                prev = curr;
            }

            // Track and update max Length
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}
