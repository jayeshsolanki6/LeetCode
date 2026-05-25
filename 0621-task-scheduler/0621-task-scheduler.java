class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] hash = new int[26];
        for(char c : tasks){
            hash[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : hash){
            if(i != 0) pq.add(i);
        }

        Queue<int[]> q = new ArrayDeque<>();

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            while(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.remove()[0]);
            }
            if(!pq.isEmpty()){
                int abc = pq.remove();
                if(abc > 1)
                    q.add(new int[]{abc - 1, time + n + 1});
            }
        }
        return time;
    }
}