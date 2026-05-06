class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        List<List<Integer>> rev = new ArrayList<>();

        for(int i = 0; i<nodes; i++){
            rev.add(new ArrayList<>());
        }

        int[] inDeg = new int[nodes];
        for(int i = 0; i<nodes; i++){
            for(int node : graph[i]){
                rev.get(node).add(i);
                inDeg[i]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<nodes; i++){
            if(inDeg[i] == 0) q.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            res.add(node);
            for(int x : rev.get(node)){
                inDeg[x]--;
                if(inDeg[x] == 0) q.add(x);
            }
        }
        Collections.sort(res);
        return res;
    }
}