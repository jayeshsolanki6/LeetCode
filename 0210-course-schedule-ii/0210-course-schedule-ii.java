class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) list.add(new ArrayList<>());

        int[] inDeg = new int[numCourses];
        for(int[] pre : prerequisites){
            list.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }
        int[] res = new int[numCourses];
        int i = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int j = 0; j<numCourses; j++){
            if(inDeg[j] == 0) q.add(j);
        }

        while(!q.isEmpty()){
            int course = q.remove();
            res[i++] = course;

            for(int adj : list.get(course)){
                inDeg[adj]--;
                if(inDeg[adj] == 0){
                    q.add(adj);
                }
            }
        }

        for(int j = 0; j<numCourses; j++){
            if(inDeg[j] != 0) return new int[0];
        }
        return res;
    }
}