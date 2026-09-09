class Solution {
    public long countCommas(long n) {
        long c = 0;
        long num = 999;

        while(num < n){
            c += n-num;
            num *= 1000;
            num += 999;
        }
        return c;
    }
}
