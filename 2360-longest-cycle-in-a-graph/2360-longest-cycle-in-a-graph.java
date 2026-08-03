class Solution {
    int max = -1;
    public int longestCycle(int[] edges) {
        int len = edges.length;

        int[] path = new int[len];
        int[] count = new int[len];

        for(int i = 0; i<len; i++){
            if(path[i] == 0){
                dfs(i, 1, path, count, edges);
            }
        }

        return max;
    }

    void dfs(int i, int c, int[] path, int[] count, int[] edges){
        path[i] = 2;
        count[i] = c;
        int adj = edges[i];

        if(adj != -1){
            if(path[adj] == 0){
                dfs(adj, c+1, path, count, edges);
            } else if(path[adj] == 2){
                max = Math.max(max, c - count[adj] + 1);
            }
        }

        path[i] = 1;
    }
}