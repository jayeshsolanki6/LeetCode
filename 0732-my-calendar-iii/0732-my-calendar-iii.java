class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0)+1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);

        int totalBooking = 0;
        int maxBooking = 0;
        for(int value : map.values()){
            totalBooking += value;
            maxBooking = Math.max(maxBooking, totalBooking);
        }

        return maxBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */