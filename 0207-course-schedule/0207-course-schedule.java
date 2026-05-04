class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) list.add(new ArrayList<Integer>());

        int[] inDeg = new int[numCourses];
        for(int[] pre : prerequisites){
            list.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<numCourses; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);
            for(int x : list.get(node)){
                inDeg[x]--;
                if(inDeg[x] == 0){
                    q.add(x);
                }
            }
        }
        if(topo.size() != numCourses) return false;
        return true;

    }
}