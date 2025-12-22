class Solution {
    public long lastInteger(long n) {
        long diff = 1;
        long num = 1;
        long non = n;  // Number of numbers
        boolean ltf = true;
        while(non != 1){
            boolean change = false;
            if(ltf){
                non = non - non/2;
            }else{
                if(non%2 == 1){
                    non = non - non/2;
                } else{
                    non = non - non/2;
                    change = true;
                }
            }
            if(change){
                num += diff;
            }
            diff = diff*2;
            ltf = !ltf;
        }
        return num;
    }
}