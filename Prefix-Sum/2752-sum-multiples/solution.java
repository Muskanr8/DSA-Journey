class Solution {

    public int sumOfMultiples(int n) {
        return sum(n, 3) + sum(n, 5) + sum(n, 7) + sum(n, 105) - sum(n, 15) - sum(n, 21) - sum(n, 35);
    }
    
    private int sum(int n, int k){
        int m = n / k;
        return k * (m * (m + 1)) / 2;
    }

}
        // int sum = 0;
        // sum += sum(n, 3);
        // sum += sum(n, 5);
        // sum += sum(n, 7);
        // sum += sum(n, 105);
        // sum -= sum(n, 15);
        // sum -= sum(n, 35);
        // sum -= sum(n, 21);

        // for(int i = 1; i <= n; i += 1){
        //     if(i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
        //         sum += i;
        //     }
        // }
