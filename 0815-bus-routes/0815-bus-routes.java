class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        int len = routes.length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i<len; i++){
            for(int stop : routes[i]){
                if(!map.containsKey(stop)){
                    map.put(stop, new ArrayList<>());   
                }
                map.get(stop).add(i);
            }
        }
        boolean[] vis = new boolean[len];
        Queue<Integer> q = new ArrayDeque<>();
        if(!map.containsKey(source) || !map.containsKey(target)) return -1;
        for(int idx : map.get(source)) {
            q.add(idx);
            vis[idx] = true;
        }
        int timer = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int bus = q.remove();
                for(int stop : routes[bus]){
                    if(stop == target) return timer;
                    for(int newBus : map.get(stop)){
                        if(!vis[newBus]){
                            q.add(newBus);
                            vis[newBus] = true;
                        }
                    }
                }
            }
            timer++;
        }

        return -1;
    }
}