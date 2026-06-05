class Solution {
    int[] parent;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        for(int i = 1; i<=n; i++) parent[i] = i;

        int len = queries.length;
        List<Boolean> res = new ArrayList<>();

        int sqrt = (int)Math.sqrt(n);
        for(int i = threshold+1; i<=n; i++){
            for(int j = i*2; j<=n; j+=i){
                union(i, j);
            }
        }

        for(int[] query : queries){
            int upx = findUParent(query[0]);
            int upy = findUParent(query[1]);
            if(upx == upy) res.add(true);
            else res.add(false);
        }

        return res;
    }
    int findUParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findUParent(parent[node]);
    }

    void union(int x, int y){
        int upx = findUParent(x);
        int upy = findUParent(y);
        if(upx == upy) return;

        parent[upx] = upy;
        return;
    }
}