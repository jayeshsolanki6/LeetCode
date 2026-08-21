class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (
            a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]
        ));

        for(int[] point : points) pq.add(point);

        int[][] res = new int[k][];
        while(k-- > 0){
            res[k] = pq.remove();
        }
        return res;
    }
}