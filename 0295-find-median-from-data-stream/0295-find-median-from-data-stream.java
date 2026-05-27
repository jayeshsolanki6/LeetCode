class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()) {
            max.add(num);
        }else{
            min.add(num);
        }
        int s1 = max.size();
        int s2 = min.size();
        if(s1 < s2-1){
            max.add(min.remove());
        } else if(s2 < s1-1){
            min.add(max.remove());
        }
        return;
    }
    
    public double findMedian() {
        int s1 = max.size();
        int s2 = min.size();
        if(s1 < s2) return (double) min.peek();
        if(s2 < s1) return (double) max.peek();

        double d = max.peek() + min.peek();
        return d/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */