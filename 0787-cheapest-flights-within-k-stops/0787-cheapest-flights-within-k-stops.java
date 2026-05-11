class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> list = new ArrayList<>();

        for(int i = 0; i<n; i++) list.add(new ArrayList<>());
        for(int[] flight : flights){
            list.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{src, 0, 0});

        while(!pq.isEmpty()){
            int[] pair = pq.remove();

            if(pair[2] > k) continue;
            for(int[] adj : list.get(pair[0])){
                int newDist = pair[1] + adj[1];
                if(newDist < dist[adj[0]]){
                    dist[adj[0]] = newDist;
                    int newK = pair[2]+1;
                    pq.add(new int[]{adj[0], newDist, newK});
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}