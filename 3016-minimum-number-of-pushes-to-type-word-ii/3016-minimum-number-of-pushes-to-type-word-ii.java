class Solution {
    public int minimumPushes(String word) {
        int[] hash = new int[26];
        for(char c : word.toCharArray()){
            hash[c-97]++;
        }
        Arrays.sort(hash);
        int ans = 0;
        int mul = 1;
        for(int i = 25, j = 1; i>=0; i--, j++){
            ans += hash[i]*mul;
            if(j%8 == 0) mul++;
        }
        return ans;
    }
}