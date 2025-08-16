class Solution {
    public int commonFactors(int a, int b) {
        int g = gcd(a, b);
        return countDivisors(g);
    }
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Function to count divisors of a number
    private static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // divisor i
                if (i != n / i) 
                    count++;
            }
        }
        return count;
    }
}
