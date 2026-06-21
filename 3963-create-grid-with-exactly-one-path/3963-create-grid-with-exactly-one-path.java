class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        char[] first = new char[n];
        Arrays.fill(first, '.');
        res[0] = new String(first);

        for(int i = 1; i<m; i++){
            char[] str = new char[n];
            Arrays.fill(str, '#');
            str[n-1] = '.';
            res[i] = new String(str);
        }

        return res;
    }
}