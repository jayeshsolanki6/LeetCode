class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int len = s.length();
        int wordsLen = words.length;
        int ans = 0;
        Map<String, Integer> mp = new HashMap<>();
        for(String word : words){
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }
        for(String word : mp.keySet()){
            if(check(word, s, word.length(), len)){
                ans += mp.get(word);
            }
        }
        return ans;
    }
    boolean check(String t, String s, int tLen, int sLen){
        int i = 0, j = 0;
        while(i < tLen && j < sLen){
            if(t.charAt(i) == s.charAt(j)){
                i++;
            }
            j++;
        }
        return i == tLen;
    }
}