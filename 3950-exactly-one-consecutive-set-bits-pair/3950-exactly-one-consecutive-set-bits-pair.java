class Solution {
    public boolean consecutiveSetBits(int n) {
        int pair = n & (n >> 1);
        return pair > 0 && (pair & (pair-1)) == 0;
    }
}