class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int qL = queries.length;
        int i = 0;
        int[] ans = new int[qL];
        for(int[] query : queries){
            int count = 0;
            for(int[] point : points){
                int lhs = (point[0] - query[0])*(point[0] - query[0]) + (point[1] - query[1])*(point[1] - query[1]);
                int rhs = query[2]*query[2];
                if(lhs <= rhs) count++;
            }
            ans[i++] = count;
        }
        return ans;
    }
}