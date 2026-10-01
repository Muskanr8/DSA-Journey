class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] diff = new int[n + 1];
        for(int[] b : bookings){
            
            diff[(b[0] - 1)] += b[2];
            diff[b[1]] -= b[2];
        }

        int[] answer = new int[n];
        answer[0] = diff[0];
        for(int i = 1; i < n; i++){
            answer[i] = answer[i - 1] + diff[i];
        }

        return answer;
    }
}