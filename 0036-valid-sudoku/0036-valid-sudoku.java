class Solution {
    public boolean isValidSudoku(char[][] board) {
        int empty1 = 0, empty2 = 0, empty3 = 0;

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();

        for(int i = 0; i<9; i++){
            int empty = 0;
            Set<Character> set = new HashSet<>();

            for(int j = 0; j<9; j++){
                if(board[i][j] == '.') empty++;
                else set.add(board[i][j]);
                if(j >= 0 && j < 3){
                    if(board[i][j] == '.') empty1++;
                    else set1.add(board[i][j]);
                } else if(j >= 3 && j < 6){
                    if(board[i][j] == '.') empty2++;
                    else set2.add(board[i][j]);
                } else{
                    if(board[i][j] == '.') empty3++;
                    else set3.add(board[i][j]);
                }
            }
            if(set.size() + empty != 9) return false;
            if(i == 2 || i == 5 || i == 8){
                if(set1.size() + empty1 != 9) return false;
                if(set2.size() + empty2 != 9) return false;
                if(set3.size() + empty3 != 9) return false;
                empty1 = 0;
                empty2 = 0;
                empty3 = 0;
                set1 = new HashSet<>();
                set2 = new HashSet<>();
                set3 = new HashSet<>();
            }
        }
        for(int i = 0; i<9; i++){
            int empty = 0;
            Set<Character> set = new HashSet<>();
            for(int j = 0; j<9; j++){
                if(board[j][i] == '.') empty++;
                else set.add(board[j][i]);
            }
            if(set.size() + empty != 9) return false;
        }

        return true;
    }
}