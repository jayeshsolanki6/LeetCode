class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num*9) return "";
        StringBuilder sb = new StringBuilder();
        while(sum > 0){
            if(sum > 8){
                sb.append('9');
                sum -= 9;
            } else{
                sb.append(sum);
                sum = 0;
            }
        }
        if(sb.length() < num){
            sb.repeat('0', num-sb.length());
        }
        return sb.toString();
    }
}