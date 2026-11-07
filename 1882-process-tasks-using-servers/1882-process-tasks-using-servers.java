class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        PriorityQueue<int[]> ava = new PriorityQueue<>((a, b) -> {
            if(a[2] != b[2]) {
                return a[2]-b[2];
            }
            return a[1]-b[1];
        });
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i = 0; i<n; i++){
            ava.add(new int[]{0, i, servers[i]});
        }

        int[] res = new int[m];
        int timer = 0;

        for(int i = 0; i<m; i++){
            timer = Math.max(timer, i);
            release(ava, busy, timer);
            if(ava.isEmpty()){
                timer = busy.peek()[0];
                release(ava, busy, timer);
            }
            int[] s = ava.remove();
            res[i] = s[1];
            s[0] = timer + tasks[i];
            busy.add(s);
        }

        return res;
    }
    void release(PriorityQueue<int[]> ava, PriorityQueue<int[]> busy, int timer){
        while(!busy.isEmpty() && busy.peek()[0] <= timer){
            ava.add(busy.remove());
        }
    }
}