class MyQueue {
    List<Integer> st1, st2;
    public MyQueue() {
        st1 = new ArrayList<>();
        st2 = new ArrayList<>();
    }
    
    public void push(int x) {
        while(st1.size() > 0){
            st2.add(st1.remove(st1.size()-1));
        }
        st1.add(x);
        while(st2.size() > 0){
            st1.add(st2.remove(st2.size()-1));
        }
    }
    
    public int pop() {
        return st1.remove(st1.size()-1);
    }
    
    public int peek() {
        return st1.get(st1.size()-1);
    }
    
    public boolean empty() {
        return st1.size() == 0;
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