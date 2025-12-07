class Solution {
    public int largestPrime(int n) {
        // primes among prefix sum of primes
        int[] ppr = { 
            2, 5, 17, 41, 197, 281, 7699, 8893, 22039,
            24133, 25237, 28697, 32353, 37561, 38921, 43201,
            44683, 55837, 61027, 66463, 70241, 86453, 
            102001, 109147, 116533, 119069, 121631, 129419, 
            132059, 263171,287137, 325019, 329401, 333821, 
            338279,  342761, 360979, 379667, 393961, 398771 
        };
        int res = 0;
        for(int i = 0; i<ppr.length; i++){
            if(ppr[i] <= n){
                res = ppr[i];
            } else{
                break;
            }
        }
        return res;
    }
    
}