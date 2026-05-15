class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge : connections){
            ds.unionBySize(edge);
        }
        return ds.getResult();
    }
}
class DisjointSet{
    int n;
    int[] size;
    int[] parent;
    int extraCable = 0;

    DisjointSet(int n){
        this.n = n;
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

    void unionBySize(int[] edge){
        int u = edge[0], v = edge[1];
        int utp_u = findUPar(u);
        int utp_v = findUPar(v);

        if(utp_u == utp_v){
            extraCable++;
            return;
        }
        int size_u = size[utp_u];
        int size_v = size[utp_v];

        if(size_u > size_v){
            parent[utp_v] = utp_u;
            size[utp_u] += size_v;
        } else{
            parent[utp_u] = utp_v;
            size[utp_v] += size_u;
        }
    }

    int getResult(){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(findUPar(i));
        }

        int cableReq = set.size()-1;
        if(cableReq <= extraCable){
            return cableReq;
        }
        return -1;
    }
}