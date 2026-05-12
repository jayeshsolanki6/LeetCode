class Solution {

    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;
        List<List<int[]>> list = new ArrayList<>();

        for(int i = 0; i<n; i++) list.add(new ArrayList<>());

        for(int[] road : roads){
            list.get(road[0]).add(new int[]{road[1], road[2]});
            list.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        for(int i = 1; i<n; i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] pair = pq.remove();
            int node = (int)pair[0];
            long time = pair[1];
            for(int[] nbr : list.get(node)){
                int u = nbr[0];
                int t = nbr[1];

                if(dist[u] > time + t){
                    dist[u] = time + t;
                    ways[u] = ways[node];
                    pq.add(new long[]{u, time+t});
                } else if(dist[u] == time + t){
                    ways[u] += ways[node];
                    ways[u] %= mod;
                }
            }
        }

        return (int)ways[n-1];
    }
}