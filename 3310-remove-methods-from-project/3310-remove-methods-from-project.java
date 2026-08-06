class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(new ArrayList<>());

        int[] inDeg = new int[n];
        for(int[] method : invocations){
            list.get(method[0]).add(method[1]);
            inDeg[method[1]]++;
        }

        Set<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[n];
        inDeg[k]++;
        dfs(k, inDeg, vis, list, set);
        List<Integer> res = new ArrayList<>();
        boolean flag = false;
        for(int i : set){
            if(inDeg[i] > 0){
                flag = true;
            }
        }
        if(flag){
            for(int i = 0; i<n; i++) res.add(i);
        } else{
            for(int i = 0; i<n; i++){
                if(!set.contains(i)) res.add(i);
            }
        }

        return res;
    }

    void dfs(int node, int[] inDeg, boolean[] vis, List<List<Integer>> list, Set<Integer> set){
        inDeg[node]--;
        if(vis[node]) return;
        set.add(node);
        vis[node] = true;

        for(int adj : list.get(node)){
            dfs(adj, inDeg, vis, list, set);
        }
    }
}