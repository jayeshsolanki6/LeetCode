class Solution {
    public int maximum69Number (int num) {
        char[] digit = String.valueOf(num).toCharArray();
        for(int i = 0; i<digit.length; i++){
            if(digit[i] - '0' == 6){
                digit[i] = '9';
                break;
            }
        }
        Integer ans = Integer.parseInt(new String(digit));
        return ans;
    }
}