class Solution {
    Set<String> set;
    int[] dp;
    public int numDecodings(String s) {
        set = new HashSet<>();
        for(int i = 1; i<=26; i++) set.add(""+i);
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return find(s.length()-1, s);
    }
    int find(int i, String s){
        if(i < 0) return 1;
        if(dp[i] != -1) return dp[i];
        int takeOne = 0, takeTwo = 0;
        if(i >= 0 && set.contains(s.substring(i, i+1))){
            takeOne += find(i-1, s);
        }
        if(i > 0 && set.contains(s.substring(i-1, i+1))){
            takeTwo += find(i-2, s);
        }

        return dp[i] = takeOne + takeTwo;
    }
}