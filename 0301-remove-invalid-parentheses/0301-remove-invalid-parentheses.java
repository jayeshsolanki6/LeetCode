class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int cnt = countBrToRemove(s);

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        find(cnt, set, s, list);
        return list;
    }

    void find(int r, Set<String> set, String s, List<String> list){
        if(set.contains(s)) return;
        set.add(s);
        if(r == 0){
            if(countBrToRemove(s) == 0){
                list.add(s);
            }
            return;
        }
        int len = s.length();
        for(int i = 0; i<len; i++){
            char c = s.charAt(i);
            if(c != '(' && c != ')') continue;
            String newStr = s.substring(0, i) + s.substring(i+1, len);
            find(r-1, set, newStr, list);
        }
    }

    int countBrToRemove(String s){
        int cnt = 0;
        int br = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                br++;
            } else if(c == ')'){
                if(br == 0) cnt++;
                else br--;
            }
        }
        return cnt + br;
    }
}