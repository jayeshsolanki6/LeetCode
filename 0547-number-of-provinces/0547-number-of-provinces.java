class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] visited = new int[len];
        int count = 0;
        for(int i = 0; i<len; i++){
            if(visited[i] == 0){
                bfs(isConnected, visited, i, len);
                count++;
            }
        }
        return count;
    }
    void bfs(int[][] arr, int[] visited, int a, int len){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<len; i++){
            if(arr[a][i] == 1 && visited[i] == 0){
                queue.add(i);
                visited[i] = 1;
            }
        }
        while(!queue.isEmpty()){
            bfs(arr, visited, queue.remove(), len);
        }
    }
}
