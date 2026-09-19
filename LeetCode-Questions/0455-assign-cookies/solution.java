class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int children = 0, cookies = 0;

        while(children < g.length && cookies < s.length) {
            if(s[cookies] >= g[children]) {
                children++;
            }
            cookies++;
        }
        return children;
    }
}
