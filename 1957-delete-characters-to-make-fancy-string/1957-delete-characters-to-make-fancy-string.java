class Solution {
    public String makeFancyString(String s) {
        int len = s.length();
        if(len<3) return s;
        int count = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        for(int i = 1; i<len; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                count++;
                if(count >= 3){
                    continue;
                }
            } else{
                count = 1;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}