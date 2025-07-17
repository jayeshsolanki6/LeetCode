class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return count(n);
    }
    int count(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        if(memo[n] != -1) return memo[n];

        int ways = count(n-1) + count(n-2);
        memo[n] = ways;
        return ways;
    }
}