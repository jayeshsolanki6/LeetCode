class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for(int[] p1 : points){
            for(int[] p2 : points){
                if(p1 == p2) continue;
                int x1 = p1[0], x2 = p2[0];
                int y1 = p1[1], y2 = p2[1];
                if(x1 <= x2 && y1 >= y2){
                    int u = y1, d = y2;
                    int l = x1, r = x2;
                    int flag = 0;
                    for(int[] p : points){
                        if(p == p1 || p == p2) continue;
                        if(p[0] >= l && p[0] <= r && p[1] <= u && p[1] >= d){
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0) count++;
                }
            }
        }
        return count;
    }
}