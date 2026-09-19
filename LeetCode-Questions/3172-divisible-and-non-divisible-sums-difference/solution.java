class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        if(m == 1){
            return -((n * (n + 1)) / 2);
        }

        int total = (n * (n + 1)) / 2;
        int k = n / m;
        num2 = m * ((k * (k + 1)) / 2);
        num1 = total - num2;

        return num1 - num2;
    }
}
        // for(int i = 1; i <= n; i += 1){
        //     if(i % m == 0){
        //         num2 += i;
        //     }
        //     else{
        //         num1 += i;
        //     }
        // }
