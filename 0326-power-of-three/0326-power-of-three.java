class Solution {
    public boolean isPowerOfThree(int n) {
        double x = Math.log(n)/Math.log(3);
        int t = (int)x;
        if(x == t) return true;
        return false;
    }
}