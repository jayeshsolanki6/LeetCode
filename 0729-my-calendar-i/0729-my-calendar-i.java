class MyCalendar {
    List<int[]> booking;
    public MyCalendar() {
        booking = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] book : booking){
            if(isOverlaping(book, startTime, endTime-1)){
                return false;
            }
        }

        booking.add(new int[]{startTime, endTime-1});
        return true;
    }

    public boolean isOverlaping(int[] book, int s2, int e2){
        int s1 = book[0], e1 = book[1];
        return s2 <= e1 && e2 >= s1;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */