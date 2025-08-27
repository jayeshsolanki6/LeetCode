class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n,n, "");
        return list;
    }
    void generate(int n, int m, String s){
        if(n == 0 && m == 0){
            list.add(s);
            return;
        }
        if(n == 0){
            generate(n, m-1, s + ")");
            return;
        }
        if(n < m){
            generate(n, m-1, s + ")");
            generate(n-1, m, s + "(");
            return;
        }
        generate(n-1, m, s + "(");
    }
}