class Solution {
    int[] memo;
    public int tribonacci(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return calculate(n);
    }
    int calculate(int n){
        if(n==0) return 0;
        if(n<=2) return 1;
        if(memo[n] != -1) return memo[n];

        int ans = calculate(n-1) + calculate(n-2) + calculate(n-3);
        memo[n] = ans;
        return ans;
    }
}