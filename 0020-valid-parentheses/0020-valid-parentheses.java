class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            } else{
                if(stack.isEmpty()) return false;
                char ch = stack.peek();
                if((ch == '(' && c ==')') || (ch == '{' && c =='}') || (ch == '[' && c ==']')){
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}