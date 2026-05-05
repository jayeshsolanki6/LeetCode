class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        int[] vis = new int[nodes];

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<nodes; i++){
            if(vis[i] == 0){
                if(dfs(i, graph, vis, set)){
                    set.add(i);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<nodes; i++){
            if(!set.contains(i)) res.add(i);
        }
        return res;
    }
    boolean dfs(int n, int[][] graph, int[] vis, Set<Integer> set){
        vis[n] = 2;
        for(int adj : graph[n]){
            if(vis[adj] == 0){
                if(dfs(adj, graph, vis, set)){
                    set.add(adj);
                    return true;
                }
            }else if(vis[adj] == 2){
                return true;
            }
        }
        vis[n] = 1;
        return false;
    }
}