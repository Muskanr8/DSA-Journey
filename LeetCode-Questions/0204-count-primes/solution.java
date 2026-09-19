class Solution {
    public int countPrimes(int n) {
        if(n <= 1)
            return 0;
        int[] primes = new int[n + 1];
        for(int i = 0; i <= n; i += 1)
            primes[i] = 1;         

        primes[0] = primes[1] = 0;

        for(int i = 2; i * i <= n; i += 1){
            if(primes[i] == 1){
                for(int j = i * i; j <= n; j += i){
                    primes[j] = 0;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i += 1){
            if(primes[i] == 1){
                count += 1;
            }
        }

        return count;
    }
}
