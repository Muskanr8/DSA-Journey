class Solution {
    public int alternateDigitSum(int n) {
        int pos;
        int sum = 0;
        int count = 0;
        int temp = n;
        while(temp != 0){
            count += 1;
            temp /= 10;
        }
        if(count % 2 == 0)
            pos = 0;
        else
            pos = 1;
        while(n != 0){
            int digit = n % 10;
            if(pos % 2 == 0){
                sum -= digit;
            }
            else{
                sum += digit;
            }
            n /= 10;
            pos += 1;
        }
        return sum;
    }
}
