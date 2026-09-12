class Solution {
    public String minWindow(String s, String t) {

        // 1. Count the frequency of every character in t → need.
        Map<Character, Integer> need = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            need.put(t.charAt(i),
                     need.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 2. Create a window map to track frequencies inside the current window.
        Map<Character, Integer> window = new HashMap<>();

        // 3. Initialize left = 0, formed = 0, minLen = Integer.MAX_VALUE, start = 0.
        int left = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // 4. Expand the window by moving right.
        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            // 5. If s[right] is required:
            if(need.containsKey(ch)){

                // Increase its window frequency.
                window.put(ch,
                          window.getOrDefault(ch, 0) + 1);

                // If its frequency reaches the required frequency, increment formed.
                if(window.get(ch).equals(need.get(ch))){
                    formed++;
                }
            }

            // 6. While the window contains all required characters:
            while(formed == need.size()){

                // Update the minimum window.
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove s[left] from the window.
                char leftChar = s.charAt(left);

                if(need.containsKey(leftChar)){

                    window.put(leftChar,
                              window.get(leftChar) - 1);

                    // If removing it makes its frequency less than required, decrement formed.
                    if(window.get(leftChar) < need.get(leftChar)){
                        formed--;
                    }
                }

                // Move left++.
                left++;
            }
        }

        // 7. Return the minimum window, or "" if no valid window exists.
        return minLen == Integer.MAX_VALUE
               ? ""
               : s.substring(start, start + minLen);
    }
}
