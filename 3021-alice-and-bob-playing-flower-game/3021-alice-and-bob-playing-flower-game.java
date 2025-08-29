class Solution {
    public long flowerGame(int n, int m) {
        int nE = n/2, nO = (n+1)/2;
        int mE = m/2, mO = (m+1)/2;
        return (long)nE*mO + (long)nO*mE;
    }
}