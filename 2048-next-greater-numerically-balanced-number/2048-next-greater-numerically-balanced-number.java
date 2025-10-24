class Solution {
    public int nextBeautifulNumber(int n) {
        for(int i = n+1;;i++){
            if(isBalanced(i)) return i;
        }
    }
    boolean isBalanced(int n){
        int[] hash = new int[10];
        while(n > 0){
            hash[n%10]++;
            n/=10;
        }
        for(int i = 0; i<10; i++){
            if(hash[i] != 0 && hash[i] != i) return false;
        }
        return true;
    }
}