class Solution {
    public boolean isPowerOfThree(int n) {
        // if(n < 1) return false;
        // double x = Math.log(n)/Math.log(3);
        // return Math.abs(x - Math.round(x)) < 1e-10;

        return n > 0 && 1162261467 % n == 0;
    }
}