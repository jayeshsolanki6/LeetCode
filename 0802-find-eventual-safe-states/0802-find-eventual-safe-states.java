class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        int[] vis = new int[nodes];
 
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<nodes; i++){
            if(vis[i] == 0){
                if(!dfs(i, graph, vis)){
                    res.add(i);
                }
            } else if(vis[i] == 1){
                res.add(i);
            }
        }

        return res;
    }
    boolean dfs(int n, int[][] graph, int[] vis){
        vis[n] = 2;
        for(int adj : graph[n]){
            if(vis[adj] == 0 && dfs(adj, graph, vis)){
                return true;
            }else if(vis[adj] == 2){
                return true;
            }
        }
        vis[n] = 1;
        return false;
    }
}