class Solution {
    public boolean isPowerOfThree(int n) {
        // if(n < 1) return false;
        // double x = Math.log(n)/Math.log(3);
        // return Math.abs(x - Math.round(x)) < 1e-10;

        // return n > 0 && 1162261467 % n == 0;

        if(n < 1) return false;
        while(n % 3 == 0){
            n = n/3;
        }
        return n == 1;
    }
}