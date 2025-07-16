class Solution {
    public boolean isValid(String word) {
        int len = word.length();
        boolean vowel = false, consonant = false;
        if(len<3) return false;
        word = word.toLowerCase();
        for(char c : word.toCharArray()){
            if(c >= '0' && c <= '9'){
                continue;
            } else if(c >= 'a' && c <= 'z'){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vowel = true;
                } else{
                    consonant = true;
                }
            } else{
                return false;
            }
        }
        return vowel && consonant;
    }
}