class Solution {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()){
            if(c == '(') i++;
            if(i > 1) sb.append(c);
            if(c == ')') i--;
        }
        return sb.toString();
    }
}