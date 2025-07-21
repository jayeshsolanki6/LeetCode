class Solution {
    public int[] asteroidCollision(int[] ast) {
        int len = ast.length;
        Stack<Integer> stack = new Stack<>();
    
        for(int i : ast){
            if(stack.isEmpty() || stack.peek() < 0 && i < 0 || i > 0){
                stack.push(i);
                continue;
            }
            if(i < 0){
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() > 0){
                    if(stack.peek() == -i){
                        stack.pop();
                    }
                } else {
                    stack.push(i);
                }
            }

        }
        int[] arr = new int[stack.size()];
        for(int i = 0; i<stack.size(); i++){
            arr[i] = stack.get(i);
        }
        return arr;
    }
}