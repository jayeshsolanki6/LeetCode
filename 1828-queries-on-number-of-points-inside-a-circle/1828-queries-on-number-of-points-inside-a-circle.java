class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int qL = queries.length;
        int i = 0;
        int[] ans = new int[qL];
        for(int[] query : queries){
            int count = 0;
            for(int[] point : points){
                int lhs = (int)Math.pow(point[0] - query[0], 2) + (int)Math.pow(point[1] - query[1], 2);
                int rhs = (int)Math.pow(query[2], 2);
                if(lhs <= rhs) count++;
            }
            ans[i++] = count;
        }
        return ans;
    }
}