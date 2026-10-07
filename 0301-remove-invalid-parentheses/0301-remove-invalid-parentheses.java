class Solution {
    public List<String> removeInvalidParentheses(String s) {
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
        cnt += br;

        Set<String> list = new HashSet<>();
        find(0, cnt, s.length(), list, new StringBuilder(), s);
        List<String> li = new ArrayList<>(list);
        return li;
    }

    void find(int i, int r, int len, Set<String> list, StringBuilder sb, String s){
        if(!isValid(sb)) return;
        if(i == len){
            if(isValidFinal(sb)){
                list.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(i);
        if(r > 0 && (ch == '(' || ch == ')')){
            find(i+1, r-1, len, list, sb, s);
        }
        sb.append(s.charAt(i));
        find(i+1, r, len, list, sb, s);
        sb.deleteCharAt(sb.length()-1);
    }

    boolean isValid(StringBuilder sb){
        int len = sb.length();
        int br = 0;
        for(char c : sb.toString().toCharArray()){
            if(c == '(') br++;
            else if(c == ')'){
                if(br == 0) return false;
                else br--;
            }
        }
        return true;
    }

    boolean isValidFinal(StringBuilder sb){
        int len = sb.length();
        int br = 0;
        for(char c : sb.toString().toCharArray()){
            if(c == '(') br++;
            else if(c == ')'){
                if(br == 0) return false;
                else br--;
            }
        }
        return br == 0;
    }
}