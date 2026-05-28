class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        int len = s.length();

        for(int i = 0; i<len; i++){
            char c = s.charAt(i);
            if(c == '(')  open.push(i);
            else if(c == ')'){
                if(!open.isEmpty()){
                    open.pop();
                } else if(!star.isEmpty()){
                    star.pop();
                } else return false;
            }
            else star.push(i);
        }

        while(!open.isEmpty() && !star.isEmpty()){
            if(open.peek() < star.peek()){
                open.pop(); star.pop();
            } else return false;
        }
        return open.isEmpty();
    }
}