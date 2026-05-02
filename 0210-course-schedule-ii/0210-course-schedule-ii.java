class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            list.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[numCourses];
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            if(vis[i] == 0 && dfs(i, list, vis, l)){
                return new int[]{};
            }
        }
        int[] res = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            res[i] = l.get(i);
        }
        return res;
    }
    boolean dfs(int i, List<List<Integer>> list, int[] vis, List<Integer> l){
        vis[i] = 2;
        List<Integer> adj = list.get(i);
        for(int x : adj){
            if(vis[x] == 0 && dfs(x, list, vis, l)){
                return true;
            } else if(vis[x] == 2){
                return true;
            }
        }
        l.add(i);
        vis[i] = 1;
        return false;
    }
}