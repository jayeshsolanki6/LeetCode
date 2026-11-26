class Solution {
    public boolean canAliceWin(int n) {
        int i = 10;
        boolean turn = false;

        while(n>=i){
            n-=i;
            turn = !turn;
            i--;
        }

        return turn;
    }
}