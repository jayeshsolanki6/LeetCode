class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];
        for(char c : text.toCharArray()){
            hash[c-'a']++;
        }

        int res = Math.min(hash[0], hash[1]); //ba
        res = Math.min(res, hash[11]/2);
        res = Math.min(res, hash[14]/2);
        res = Math.min(res, hash[13]);
        return res;
    }
}