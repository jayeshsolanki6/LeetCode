class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length();
        return find(0, len-1, s);
    }
    int find(int i, int j, String s){
        if(i>=j) return 0;
        int res = 0;
        int k = i+1;
        int b = 1;
        while(b != 0){
            if(s.charAt(k) == ')') b--;
            else b++;
            k++;
        }
        if(k-i == 2) res = 1 + find(k, j, s);
        else res = 2*find(i+1, k-1, s) + find(k, j, s);
        return res;
    }
}