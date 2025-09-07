class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for(int i = 0; i<n/2; i++){
            res[i] = n/2 - i;
            res[n-i-1] = -(n/2 - i);
        }
        return res;
    }
}