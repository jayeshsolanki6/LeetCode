class Solution {

    List<List<Integer>> list;
    public int largestPathValue(String colors, int[][] edges) {
        int len = colors.length();
        list = new ArrayList<>();
        for(int i = 0; i<len; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
        }

        List<Integer> topo = new ArrayList<>();
        int[] path = new int[len];

        for(int i = 0; i<len; i++){
            if(path[i] == 0 && dfs(i, path, topo)){
                return -1;
            }
        }

        Collections.reverse(topo);
        int[][] dp = new int[len][26];

        int max = 1;
        for(int node : topo){
            max = Math.max(max, ++dp[node][colors.charAt(node)-97]);

            for(int adj : list.get(node)){
                for(int j = 0; j<26; j++){
                    dp[adj][j] = Math.max(dp[adj][j], dp[node][j]);
                }
            }
        }
        return max;
    }

    public boolean dfs(int node, int[] path, List<Integer> res){
        path[node] = 2;

        for(int adj : list.get(node)){
            if(path[adj] == 0){
                if(dfs(adj, path, res)){
                    return true;
                }
            } else if(path[adj] == 2) {
                return true;
            }
        }

        res.add(node);
        path[node] = 1;
        return false;
    }
}