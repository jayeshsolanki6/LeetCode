class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        Deque<String> dq = new ArrayDeque<>();

        for(String s : dir){
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..")){
                if(!dq.isEmpty()){
                     dq.removeLast();
                }
            }
            else dq.addLast(s);
        }

        StringBuilder sb = new StringBuilder();
        for(String s : dq){
            sb.append("/");
            sb.append(s);
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}