class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0) return num;
        if(len == k) return "0";
        Deque<Character> st = new LinkedList<>();
        for(char c : num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.getLast() > c) {
                st.removeLast();
                k--;
            }
            st.addLast(c);
        }
        while(k > 0) st.removeLast();
        while(!st.isEmpty() && st.getFirst() == '0') st.removeFirst();
        if(st.size() == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.removeFirst());
        }
        return sb.toString();
    }
}