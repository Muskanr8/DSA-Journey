class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        if(n == 5){
            return n / 5;
        }
        else{
        while(n >= 5){
            int rem = n / 5;
            sum += rem;
            n /= 5;
        }
        }
        return sum;
    }
}
