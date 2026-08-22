class FreqStack {
    HashMap<Integer, Stack<Integer>> map;
    HashMap<Integer, Integer> freq;
    int maxF;
    public FreqStack() {
        map = new HashMap<>();
        freq = new HashMap<>();
        maxF = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0)+1;
        freq.put(val, f);
        maxF = Math.max(maxF, f);
        if(!map.containsKey(f)) map.put(f, new Stack<>());
        map.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> st = map.get(maxF);
        int val = st.pop();
        freq.put(val, freq.get(val)-1);
        if(st.isEmpty()) maxF--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */