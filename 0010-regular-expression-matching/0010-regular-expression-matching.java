class Solution {
    public boolean isMatch(String s, String p) {
        s = s.replaceAll("\\*+", "*");
        p = p.replaceAll("\\*+", "*");
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return check(0, 0, s.length(), p.length(), s, p, dp);
    }
    boolean check(int i, int j, int n, int m, String s, String p, Boolean[][] dp){
        if(i == n && j == m) return true;
        if(j == m) return false;
        if(i == n){
            while(j+1 < m && p.charAt(j+1) == '*') j = j+2;
            if(j == m) return true;
            return false;
        }
        if(dp[i][j] != null) return dp[i][j];
        boolean res = false;

        char a = s.charAt(i);
        char b = p.charAt(j);
        if(j+1 < m && p.charAt(j+1) == '*'){
            if(a == b || b == '.'){
                res |= check(i+1, j, n, m, s, p, dp)| check(i+1, j+2, n, m, s, p, dp);
            }
            res |= check(i, j+2, n, m, s, p, dp);
        } else{
            if(a == b || b == '.'){
                res |= check(i+1, j+1, n, m, s, p, dp);
            }
        }

        return dp[i][j] = res;
    }
}