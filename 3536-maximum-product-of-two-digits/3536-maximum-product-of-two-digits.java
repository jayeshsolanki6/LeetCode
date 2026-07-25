class Solution {
    public int maxProduct(int n) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        while(n > 0){
            int num = n%10;
            n/=10;
            if(num >= m1){
                m2 = m1;
                m1 = num;
            } else if(num > m2){
                m2 = num;
            }
        }
        return m1*m2;
    }
}