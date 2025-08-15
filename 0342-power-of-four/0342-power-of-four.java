class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n<=3) return false;
        return 1073741824 % n == 0;
    }
}