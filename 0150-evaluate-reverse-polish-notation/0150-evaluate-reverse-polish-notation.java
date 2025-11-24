class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.length() == 1 && s.charAt(0) == '+'){
                int b = st.pop();
                int a = st.pop();
                st.push(a+b);
            } else if(s.length() == 1 && s.charAt(0) == '-'){
                int b = st.pop();
                int a = st.pop();
                st.push(a-b);
            } else if(s.length() == 1 && s.charAt(0) == '*'){
                int b = st.pop();
                int a = st.pop();
                st.push(a*b);
            } else if(s.length() == 1 && s.charAt(0) == '/'){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            } else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}