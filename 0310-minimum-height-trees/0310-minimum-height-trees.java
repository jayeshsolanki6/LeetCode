class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(new ArrayList<>());

        int[] inDeg = new int[n];

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            if(inDeg[i] == 1) q.add(i);
        }

        int nodes = n;

        while(nodes > 2){
            int size = q.size();
            nodes -= size;
            while(size-- > 0){
                int leaf = q.remove();
                for(int adj : list.get(leaf)){
                    if(--inDeg[adj] == 1){
                        q.add(adj);
                    }
                }
            }
        }

        res.addAll(q);
        return res;
    }
}