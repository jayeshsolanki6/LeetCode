class Solution {
    public int numberOfSpecialChars(String word) {
        int[][] hash = new int[26][4];

        int len = word.length();

        for(int i = 0; i<len; i++){
            char c = word.charAt(i);
            if('a' <= c && c <= 'z'){
                hash[c-'a'][0]++;
                hash[c-'a'][2] = i;
            } else{
                hash[c-'A'][1]++;
                if(hash[c-'A'][1] == 1){
                    hash[c-'A'][3] = i;
                }
            }
        }

        int count = 0;
        for(int i = 0; i<26; i++){
            if(hash[i][0] > 0 && hash[i][1] > 0){
                if(hash[i][2] < hash[i][3]) count++;
            }
        }

        return count;
    }
}