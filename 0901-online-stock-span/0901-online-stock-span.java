class StockSpanner {
    ArrayList<Integer> list = new ArrayList<>();
    public StockSpanner() {
    }
    
    public int next(int price) {
        int span = 1;
        int len = list.size();
        int i = len-1;
        while(i >= 0 && list.get(i) <= price){
            span++;
            i--;
        }
        list.add(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */