class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        parent = new int[size+1];
        for(int i = 0; i<=size; i++) parent[i] = i;

        for(int[] edge : edges){
            if(union(edge)) return edge;
        }
        return edges[0];
    }

    int findUParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findUParent(parent[node]);
    }

    boolean union(int[] edge){
        int upx = findUParent(edge[0]);
        int upy = findUParent(edge[1]);

        if(upx == upy) return true;
        parent[upx] = upy;
        return false;
    }
}