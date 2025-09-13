class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] hash = new int[26];
        int left = 0, right = 0;
        int maxF = 0;
        int ans = 0;
        while(right < len){
            hash[s.charAt(right) - 'A']++;
            maxF = Math.max(maxF, hash[s.charAt(right) - 'A']);
            while(right - left + 1 - maxF > k){
                hash[s.charAt(left) - 'A']--;
                left++;
                for(int i = 0; i<26; i++){
                    maxF = Math.max(hash[i], maxF);
                }
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}