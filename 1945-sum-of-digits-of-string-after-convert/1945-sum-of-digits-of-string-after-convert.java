class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            int a = (int)s.charAt(i) - 96;
            while(a>0){
                sum += a%10;
                a/=10;
            }
        }
        if(k == 1){
            return sum;
        }
        while(k>1){
            int temp = sum;
            sum = 0;
            while(temp>0){
                sum += temp%10;
                temp /= 10;
            } k--;
        } return sum;
    }
}