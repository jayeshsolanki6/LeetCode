class Solution {
    public boolean checkValidString(String s) {
        int open = 0, close = 0;

        int len = s.length();

        for(int i = 0; i<len; i++){
            char c = s.charAt(i);
            char ch = s.charAt(len-i-1);

            if(c == '(' || c == '*')  open++;
            else open--;

            if(ch == ')' || ch == '*')  close++;
            else close--;

            if(open < 0 || close < 0) return false;

        }

        return true;
    }
}