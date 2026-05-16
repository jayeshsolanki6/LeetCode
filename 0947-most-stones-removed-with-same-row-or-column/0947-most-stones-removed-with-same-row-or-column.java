class Solution {
    int[] parent;
    public int removeStones(int[][] stones) {
    
        parent = new int[20002];
        for(int i = 0; i<20002; i++) parent[i] = i;

        for(int[] pair : stones){
            int x = pair[0], y = pair[1] + 10001;
            union(x, y);
        }
        Set<Integer> com = new HashSet<>();
        for(int[] stone : stones){
            com.add(findUPar(stone[0]));
        }

        return stones.length - com.size();
    }

    int findUPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findUPar(parent[n]);
    }

    void union(int x, int y){
        int upx = findUPar(x);
        int upy = findUPar(y);
        if(upx != upy){
            parent[upx] = upy;
        }
    }

}
