class Solution {
    public boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        if(bills[0] > 5) return false;
        int c5 = 0, c10 = 0, c20 = 0;
        for(int i : bills){
            if(i == 5){
                c5++;
                continue;
            } else if(i == 10){
                if(c5 > 0){
                    c5--;
                    c10++;
                } else return false;
            } else{
                i = i - 5;
                while(i - 10 >= 0 && c10 > 0){
                    i = i-10;
                    c10--;
                }
                while(i - 5 >= 0 && c5 > 0){
                    i = i-5;
                    c5--;
                }
                if(i != 0) return false;
            }
        }
        return true;
    }
}