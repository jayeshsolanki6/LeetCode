class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> in = new ArrayList<>();
            int[] dp = new int[i+1];
            Arrays.fill(dp, -1);
            for(int j = 0; j<=i; j++){
                if(dp[j] != -1){
                    in.add(dp[j]);
                } else{
                    int add = nCr(i, j);
                    in.add(add);
                    dp[j] = add;
                }
            }
            list.add(in);
        }
        return list;
    }
    int nCr(int n, int c){
        int ans = 1;
        if(c > n/2) c = n-c;
        for(int i = 1; i<=c; i++){
            ans *= n;
            ans /= i;
            n--;
        }
        return ans;
    }
}