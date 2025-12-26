class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length();
        int preSum = 0;
        for(char c : customers.toCharArray()){
            preSum += (c == 'Y') ? 1 : 0;
        }
        int pen = preSum;
        int res = 0;
        for(int i = 0; i<len; i++){
            if(customers.charAt(i) == 'Y') preSum--;
            else preSum++;
            if(preSum < pen){
                pen = preSum;
                res = i+1;
            }
        }
        return res;
    }
}