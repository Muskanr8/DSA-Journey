class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int minLen = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int r = 0; r < cards.length; r++){

            if(map.containsKey(cards[r])){

                int len = r - map.get(cards[r]) + 1;
                minLen = Math.min(len, minLen);
            }

            map.put(cards[r], r);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
