class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int len = points.length;
        for(int i = 1; i<len; i++){
            int xTime = Math.abs(points[i-1][0]-points[i][0]);
            int yTime = Math.abs(points[i-1][1]-points[i][1]);
            time += Math.max(xTime, yTime);
        }
        return time;
    }
}