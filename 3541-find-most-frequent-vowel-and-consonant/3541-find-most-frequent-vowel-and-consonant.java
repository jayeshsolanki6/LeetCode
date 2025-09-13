class Solution {
    public int maxFreqSum(String s) {
        int[]vowel = new int[26]; 
        int[]cons = new int[26];
        int vMax = 0;
        int cMax = 0;
        for(char c : s.toCharArray()){
            if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
                int ind = c - 'a';
                vowel[ind]++;
                vMax = Math.max(vMax, vowel[ind]);
            } else{
                int ind = c - 'a';
                cons[ind]++;
                cMax = Math.max(cMax, cons[ind]);
            }
        } 
        return vMax + cMax;
    }
}