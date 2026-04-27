class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) list.add(new ArrayList<Integer>());

        for(int[] pre : prerequisites){
            list.get(pre[1]).add(pre[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(list, i, vis, path)) return false;
            }
        }
        return true;
    }
    boolean dfs(ArrayList<ArrayList<Integer>> list, int v, boolean[] vis, boolean[] path){
        vis[v] = true;
        path[v] = true;
        ArrayList<Integer> nab = list.get(v);
        for(int n : nab){
            if(!vis[n]){
                if(dfs(list, n, vis, path)) return true;
            } else if(path[n]){
                return true;
            }
        }
        path[v] = false;
        return false;
    }
}