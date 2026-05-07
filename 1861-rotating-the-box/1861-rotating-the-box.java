class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] res = new char[n][m];

        for(int i = 0; i<m; i++){
            int emp = n-1;
            for(int j = n-1; j>=0; j--){
                if(boxGrid[i][j] == '#'){
                    res[emp][m-i-1] = '#';
                    emp--;
                } else if(boxGrid[i][j] == '*'){
                    while(emp > j) res[emp--][m-i-1] = '.';
                    res[emp--][m-i-1] = '*';
                }
            }
            while(emp >= 0) res[emp--][m-i-1] = '.';
        }
        return res;
    }
}