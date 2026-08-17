class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        return check(m-1, n-1, s, t);
    }

    boolean check(int i, int j, String s, String t){
        if(i == -1) return true;
        if(j == -1) return false;

        for(int k = j; k>=0; k--){
            if(s.charAt(i) == t.charAt(k)){
                if(check(i-1, k-1, s, t)) return true;
            }
        }

        return false;
    }
}