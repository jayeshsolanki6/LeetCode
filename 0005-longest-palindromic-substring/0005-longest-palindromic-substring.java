class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;
        for(int i = len-1; i >= 0; i--){
            int low = 0, high = i;
            while(high<len){
                if(check(s, low, high)){
                    return s.substring(low, high+1);
                }
                low++; high++;
            }
        }
        return "";
    }
    boolean check(String s, int low, int high){
        if(high <= low) return true;
        if(s.charAt(low) != s.charAt(high)){
            return false;
        }
        return check(s, low+1, high-1);
    }
}