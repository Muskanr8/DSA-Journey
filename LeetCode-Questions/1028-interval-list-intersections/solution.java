class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if(firstList.length == 0 || secondList.length == 0){
            return new int[0][0];
        }

        int i = 0, j = 0, start = 0, end = 0;

        List<int[]> ans = new ArrayList<>();

        while(i < firstList.length && j < secondList.length){

            start = Math.max(firstList[i][0], secondList[j][0]);
            end = Math.min(firstList[i][1], secondList[j][1]);

            if(end >= start){
                ans.add(new int[]{start, end});
            }

            if(end == firstList[i][1]){
                i++;
            }

            if(end == secondList[j][1]){
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
