class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 1) return false;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(28);
        arr.add(496);
        arr.add(8128);
        arr.add(33550336);

        return arr.contains(num);
    }
}
        // int sum = 1;
        // for(int i = 2; i * i <= num; i += 1){
        //     if(num % i == 0){
        //         sum += i;
        //         if(num / i != i){
        //             sum += num / i;
        //         }
        //     }
        // }
        // return num == sum;
