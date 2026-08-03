class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];

        for(int i = 0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, path, graph);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<V; i++){
            if(!path[i]) list.add(i);
        }
        return list;
        
    }
    boolean dfs(int i, boolean[] vis, boolean[] path, int[][] graph){
        vis[i] = true;
        path[i] = true;

        for(int adj : graph[i]){
            if(path[adj]){
                return true;
            } else if(!vis[adj]){
                if(dfs(adj, vis, path, graph)){
                    return true;
                }
            }
        }

        path[i] = false;
        return false;
    }
}