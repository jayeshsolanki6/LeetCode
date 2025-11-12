class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;
        int temp = n;
        int pow = 0;
        while(temp > 0){
            temp /= 2;
            pow++;
        }
        return ((1<<pow) - 1 - minimumOneBitOperations(n ^ (1<<(pow-1))));
    }
}