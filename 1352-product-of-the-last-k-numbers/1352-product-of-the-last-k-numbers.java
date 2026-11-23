class ProductOfNumbers {
    ArrayList<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) list = new ArrayList<>();
        else if(list.size() == 0) list.add(num);
        else list.add(list.get(list.size()-1)*num);
    }
    
    public int getProduct(int k) {
        int size = list.size();
        if(size < k) return 0;
        if(k == size) return list.get(size-1); 
        return list.get(size-1) / list.get(size-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */