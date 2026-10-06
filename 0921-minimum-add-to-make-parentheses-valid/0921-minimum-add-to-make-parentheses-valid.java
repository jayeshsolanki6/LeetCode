class Solution {
    public int minAddToMakeValid(String s) {
        int br = 0;
        int res = 0;
        for(char c : s.toCharArray()){
            if(c == '(') br++;
            else{
                if(br == 0) res++;
                else br--;
            }
        }

        return res + br;
    }
}