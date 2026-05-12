class Solution {
    class Pair{
        int node, time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();

        for(int i = 0; i<n; i++) list.add(new ArrayList<>());

        for(int[] time : times){
            list.get(time[0]-1).add(new int[]{time[1]-1, time[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(k-1, 0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int time = p.time;

            for(int[] adj : list.get(node)){
                int u = adj[0], wt = adj[1];
                int newTime = time + wt;
                if(dist[u] > newTime){
                    dist[u] = newTime;
                    pq.add(new Pair(u, newTime));
                }
            }
        }

        int max = 0;
        for(int d : dist){
            if(d == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, d);
        }
        return max;
    }
}