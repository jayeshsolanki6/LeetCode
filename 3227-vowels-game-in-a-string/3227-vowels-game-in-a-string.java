class Solution {
    public boolean doesAliceWin(String s) {
        int len = s.length();
        int vC = 0;
        for(char c : s.toCharArray()){
            if(isVowel(c)) return true;
        }
        return false;

    }
    boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}