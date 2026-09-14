class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return find(s.length()-1, s);
    }
    int find(int i, String s){
        if(i < 0) return 1;
        if(dp[i] != -1) return dp[i];
        int takeOne = 0, takeTwo = 0;
        if(i >= 0 && s.charAt(i) != '0'){
            takeOne += find(i-1, s);
        }
        if(i > 0 && s.charAt(i-1) != '0'){
            int num = Integer.parseInt(s.substring(i-1, i+1));
            if(num <= 26)
                takeTwo += find(i-2, s);
        }

        return dp[i] = takeOne + takeTwo;
    }
}