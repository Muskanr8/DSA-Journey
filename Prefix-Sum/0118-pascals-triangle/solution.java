class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        int a = 1;
        for(int i = 0; i < numRows; i += 1){
            List<Integer> row = new ArrayList<>();
            a = 1;
            for(int j = 0; j <= i; j += 1){
                row.add(a);
                a = a * (i - j) / (j + 1);
            }
            arr.add(row);
        }
        return arr;
    }
}
