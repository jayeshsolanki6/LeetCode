class Solution {
    public int maxFreqSum(String s) {
        int[]alpha = new int[26]; 
        int vMax = 0;
        int cMax = 0;
        for(char c : s.toCharArray()){
            if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
                int ind = c - 'a';
                alpha[ind]++;
                vMax = Math.max(vMax, alpha[ind]);
            } else{
                int ind = c - 'a';
                alpha[ind]++;
                cMax = Math.max(cMax, alpha[ind]);
            }
        } 
        return vMax + cMax;
    }
}