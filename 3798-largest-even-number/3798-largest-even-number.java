class Solution {
    public String largestEven(String s) {
        int len = s.length();
        for(int i = len-1; i>=0; i--){
            if(s.charAt(i) == '2'){
                return s.substring(0, i+1);
            }
        }
        return "";
    }
}