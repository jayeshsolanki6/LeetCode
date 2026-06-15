class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer floor = map.floorKey(startTime);
        if(floor != null && map.get(floor) > startTime) return false;

        Integer ceil = map.ceilingKey(startTime);
        if(ceil != null && ceil < endTime) return false;

        map.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */