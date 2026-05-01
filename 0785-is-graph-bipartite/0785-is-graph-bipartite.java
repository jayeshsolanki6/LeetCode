class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] vis = new int[len];

        for(int i = 0; i<len; i++){
            if(vis[i] == 0){
                if(!dfs(i, graph, vis, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int i, int[][] graph, int[] vis, int color){
        if(vis[i] != 0){
            if(vis[i] == color) return true;
            return false;
        }
        vis[i] = color;
        color = (color == 1) ? 2 : 1;
        for(int n : graph[i]){
            if(!dfs(n, graph, vis, color)){
                return false;
            }
        }
        return true;
    }
}