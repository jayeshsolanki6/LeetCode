class MinStack {
    int min;
    List<int[]> list;
    public MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        min = Math.min(min, value);
        list.add(new int[]{value, min});
    }
    
    public void pop() {
        list.remove(list.size()-1);
        if(list.size() > 0) min = list.get(list.size()-1)[1];
        else min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return list.get(list.size()-1)[0];
    }
    
    public int getMin() {
        return list.get(list.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */