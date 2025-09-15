class Solution {
    public int canBeTypedWords(String text, String bL) {
        // Set<Character> set = new HashSet<>();
        // for(char c : bL.toCharArray()){
        //     set.add(c);
        // }
        int isBroken = 0;
        int count = 0;
        for(int i = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if(c == ' '){
                if(isBroken == 0) count++;
                else isBroken = 0;
            }
            if(bL.contains(c + "")) isBroken++;
        }
        if(isBroken == 0) count++;
        return count;
    }
}