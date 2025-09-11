class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(char c : s.toCharArray()){
            if(isVowel(c)) pq.add(c);
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                sb.setCharAt(i, pq.remove());
            }
        }
        return sb.toString();
    }
    boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }
}