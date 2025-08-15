class Solution {
    public int findCircleNum(int[][] isConnected) {
        int r = isConnected.length;
        int c = isConnected[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<r; i++){
            list.add(new ArrayList());
            for(int j = 0; j<c; j++){
                if(isConnected[i][j] == 1){
                    list.get(i).add(j);
                } 
            }
        }
        int[] visited = new int[r];
        int count = 0;
        for(int i = 0; i<r; i++){
            if(visited[i] == 0){
                count++;
                traverse(list, i,visited);
            }
        }
        return count;
    }
    void traverse(List<List<Integer>> list, int a, int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[a] = 1;
        for(int i : list.get(a)){
            if(visited[i] == 0){
                queue.add(i);
                visited[i] = 1;
            }
        }
        while(!queue.isEmpty()){
            traverse(list, queue.remove(), visited);
        }
    }
}