class Solution {
    List<List<Integer>> bridge = new ArrayList<>();
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int len = connections.size();

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(new ArrayList<>());

        for(List<Integer> edge : connections){
            list.get(edge.get(0)).add(edge.get(1));
            list.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] vis = new boolean[n];
        int[] dt = new int[n]; //discover time
        int[] low = new int[n]; // lowest time

        for(int i = 0; i<n; i++){
            if(!vis[i]){
                dfs(i, -1, vis, dt, low, list);
            }
        }
        return bridge;

    }
    void dfs(int node, int parent, boolean[] vis, int[] dt, int[] low, List<List<Integer>> list){
        vis[node] = true;
        dt[node] = low[node] = timer++;

        for(int adj : list.get(node)){
            if(!vis[adj]){
                dfs(adj, node, vis, dt, low, list);
                if(dt[node] < low[adj]){
                    List<Integer> edge = new ArrayList<>();
                    edge.add(node);
                    edge.add(adj);
                    bridge.add(edge);
                } else{
                    low[node] = Math.min(low[node], low[adj]);
                }
            } else if(adj != parent){
                low[node] = Math.min(low[node], low[adj]);
            }
        }
    }
}