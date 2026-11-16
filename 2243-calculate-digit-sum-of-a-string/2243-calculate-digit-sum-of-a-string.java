class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k){
            int len = sb.length();
            StringBuilder nsb = new StringBuilder();
            int i = 0;
            while(i<len){
                int sum = 0;
                for(int j = 0; j<k && j+i < len; j++){
                    sum += sb.charAt(j+i) - '0';
                }
                i += k;
                nsb.append(sum);
            }
            sb = nsb;
        }
        return sb.toString();
    }
}