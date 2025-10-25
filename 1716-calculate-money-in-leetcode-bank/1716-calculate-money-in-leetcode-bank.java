class Solution {
    public int totalMoney(int n) {
        int num = 1;
        int ans = 0;
        while(n > 0){
            int add = num;
            for(int i = 0; i<7 && n > 0; i++){
                ans += add++;
                n--;
            }
            num++;
        }
        return ans;
    }
}