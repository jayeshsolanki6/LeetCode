class Solution {
    public int removeStones(int[][] stones) {
        int len = stones.length;
        int x = 0, y = 0;
        for(int[] pair : stones){
            x = Math.max(x, pair[0]);
            y = Math.max(y, pair[1]);
        }

        DisjointSet ds = new DisjointSet(x + y + 2);

        Set<Integer> set = new HashSet<>();

        for(int[] pair : stones){
            int i = pair[0];
            int j = pair[1] + x + 1;
            ds.unionBySize(i, j);
            set.add(i);
            set.add(j);
        }

        int com = 0;

        for(int node : set){
            if(ds.findUPar(node) == node) com++;
        }
        return len - com;
    }

}

class DisjointSet{
    int[] size, parent;

    DisjointSet(int n){
        size = new int[n];
        Arrays.fill(size, 1);
        parent = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
    }

    int findUPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findUPar(parent[n]);
    }

    void unionBySize(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return;

        int size_u = size[up];
        int size_v = size[vp];

        if(size_u > size_v){
            parent[vp] = up;
            size[up] += size_v;
        } else{
            parent[up] = vp;
            size[vp] += size_u;
        }
    }
}