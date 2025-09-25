class Solution {
    public int subtractProductAndSum(int n) {
        long prod = 1, sum = 0;
        int copy = n;
        while(copy > 0){
            int l = copy%10;
            copy /= 10;
            prod*=l;
            sum+=l;
        }
        return (int)(prod - sum);
    }
}