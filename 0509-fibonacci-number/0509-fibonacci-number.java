class Solution {
    int[] memo;
    public int fib(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return f(n);
        // if(n<=1)return n;
        // int first = 0, sec = 1;
        // int fib = 0;
        // while(n-1>0){
        //     fib = first+sec;
        //     first = sec;
        //     sec = fib;
        //     n--;
        // }
        // return fib;
    }
    int f(int n){
        if(n<=1) return n;
        if(memo[n] != -1) return memo[n];
        int fact = f(n-1) + f(n-2);
        memo[n] = fact;
        return fact;
    }
}