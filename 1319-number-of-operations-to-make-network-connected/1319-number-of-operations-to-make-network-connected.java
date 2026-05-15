class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(new ArrayList<>());

        for(int[] edge : connections){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        int components = 0;
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                components++;
                dfs(i, list, vis);
            }
        }
        
        return components-1;
    }
    void dfs(int node, List<List<Integer>> list, boolean[] vis){
        if(vis[node]) return;
        vis[node] = true;

        for(int adj : list.get(node)){
            dfs(adj, list, vis);
        }
    }
}