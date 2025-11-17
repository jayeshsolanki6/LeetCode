class Solution {
    public int numSub(String s) {
        long count = 0;
        long total = 0;
        for(char c : s.toCharArray()){
            if(c == '1') count++;
            else{
                total += count*(count+1)/2 % (1e9+7L);
                count = 0;
            }
        }
        total += count*(count+1)/2;
        return (int)total;
    }
}