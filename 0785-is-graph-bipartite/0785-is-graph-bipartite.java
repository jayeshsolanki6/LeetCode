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
            if(vis[i] != color) return false;
            return true;
        }
        vis[i] = color;
        for(int j : graph[i]){
            if(!dfs(j, graph, vis, (color == 1)?2:1)){
                return false;
            }
        }

        return true;
    }
}