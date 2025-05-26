class Solution {
    public int fib(int n) {
        // return f(n);
        if(n<=1)return n;
        int first = 0, sec = 1;
        int fib = 0;
        while(n-1>0){
            fib = first+sec;
            first = sec;
            sec = fib;
            n--;
        }
        return fib;
    }
    // public static int f(int n){
    //     if(n<=1) return n;
    //     return f(n-1) + f(n-2);
    // }
}