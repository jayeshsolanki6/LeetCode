class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            list.get(u).add(new int[]{v, wt});
            list.get(v).add(new int[]{u, wt});
        }

        int minCities = Integer.MAX_VALUE;
        int city = -1;

        for(int i = 0; i<n; i++){
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            dijkstra(i, list, dist);
            int count = 0;
            for(int d : dist){
                if(d <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minCities){
                minCities = count;
                city = i;
            }
        }

        return city;
    }

    void dijkstra(int src, List<List<int[]>> list, int[] dist){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{src, 0});

        while(!pq.isEmpty()){
            int[] pair = pq.remove();
            int node = pair[0];
            int dis = pair[1];

            for(int[] adj : list.get(node)){
                int newDist = dis + adj[1];
                if(newDist < dist[adj[0]]){
                    dist[adj[0]] = newDist;
                    pq.add(new int[]{adj[0], newDist});
                }
            }
        }
        return;
    }
}