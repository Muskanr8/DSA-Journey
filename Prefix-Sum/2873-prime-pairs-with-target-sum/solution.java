class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

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

        for(int i = 2; i <= n / 2; i += 1){
            if(primes[i] == 1 && primes[n - i] == 1) {
                List<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                arr.add(n - i);
                result.add(arr);
            }
        }
        return result;
    }
}
