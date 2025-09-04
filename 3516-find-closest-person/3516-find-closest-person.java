class Solution {
    public int findClosest(int x, int y, int z) {
        int p1d = Math.abs(z-x);
        int p2d = Math.abs(z-y);
        if(p1d == p2d) return 0;
        if(p1d < p2d) return 1;
        else return 2;
    }
}