class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0)+1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);

        int totalBooking = 0;
        for(int key : map.keySet()){
            totalBooking += map.get(key);
            if(totalBooking >= 2){
                map.put(startTime, map.getOrDefault(startTime, 0)-1);
                map.put(endTime, map.getOrDefault(endTime, 0)+1);
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */