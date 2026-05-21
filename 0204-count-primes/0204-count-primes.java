class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;

        boolean[] seive = new boolean[n];

        for(int i = 2; i*i<=n; i++){
            for(int j = i+i; j<n; j+=i){
                if(!seive[j]) seive[j] = true;
            }
        }

        int count = 0;
        for(int i = 2; i<n; i++){
            if(!seive[i]) count++;
        }
        return count;
    }
}