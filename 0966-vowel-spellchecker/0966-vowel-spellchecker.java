class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        HashMap<String, String> capitlization = new HashMap<>();
        HashMap<String, String> vowelError = new HashMap<>();

        for(String s : wordlist){
            exactMatch.add(s);
            capitlization.putIfAbsent(s.toLowerCase(), s);
            String noVowel = removeVowel(s);
            vowelError.putIfAbsent(noVowel, s);
        }
        int len = queries.length;
        String[] res = new String[len];
        for(int i = 0; i<len; i++){
            String st = queries[i];
            if(exactMatch.contains(st)){
                res[i] = st;
                continue;
            }
            String lst = st.toLowerCase();
            if(capitlization.containsKey(lst)){
                res[i] = capitlization.get(lst);
                continue;
            }
            String noV = removeVowel(st);
            if(vowelError.containsKey(noV)){
                res[i] = vowelError.get(noV);
                continue;
            }
            res[i] = "";
        }
        return res;
    }
    String removeVowel(String s){
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        for(int i = 0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                sb.setCharAt(i, '#');
            }
        }
        return sb.toString();
    }
}