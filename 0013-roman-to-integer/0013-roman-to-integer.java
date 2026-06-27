class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int last = 0;
        for(char c : s.toCharArray()){
            int val = getNum(c);
            res += val;
            if(val > last){
                res -= 2*last;
            }
            last = val;
        }
        return res;
    }
    int getNum(char c){
        if(c == 'I') return 1;
        else if(c == 'V') return 5;
        else if(c == 'X') return 10;
        else if(c == 'L') return 50;
        else if(c == 'C') return 100;
        else if(c == 'D') return 500;
        else return 1000;
    }
}