class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        if(len != goal.length()) return false;
        for(int i = 0; i<len; i++){
            for(int j = 0; j<len; j++){
                if(s.charAt((i+j)%len) != goal.charAt(j)){
                    break;
                }
                if(j == len-1) return true;
            }
        }
        return false;
        // String ss = s+s;
        // return ss.contains(goal);
    }
}