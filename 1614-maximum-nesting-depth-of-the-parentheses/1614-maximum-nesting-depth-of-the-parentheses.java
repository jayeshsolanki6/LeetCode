class Solution {
    public int maxDepth(String s) {
        int max = 0, cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                cnt++;
                max = Math.max(max, cnt);
            }
            if(c == ')'){
                cnt--;
            }
        }
        return max;
    }
}