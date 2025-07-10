class MyQueue {
    Stack<Integer> stack, temp;
    public MyQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int x) {
        int size = stack.size();
        for(int i = 0; i<size; i++){
            temp.push(stack.pop());
        }
        stack.push(x);
        for(int i = 0; i<size; i++){
            stack.push(temp.pop());
        }
    }
    
    public int pop() {
        if(stack.isEmpty()) return -1;
        return stack.pop();
    }
    
    public int peek() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */