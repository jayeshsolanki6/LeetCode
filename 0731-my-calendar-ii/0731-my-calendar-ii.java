class MyCalendarTwo {
    List<int[]> booking;
    List<int[]> overlapingBookings;

    public MyCalendarTwo() {
        booking = new ArrayList<>();
        overlapingBookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] overBook : overlapingBookings){
            if(isOverlaping(overBook, startTime, endTime-1)){
                return false;
            }
        }

        for(int[] book : booking){
            if(isOverlaping(book, startTime, endTime-1)){
                overlapingBookings.add(new int[]{
                    Math.max(book[0], startTime),
                    Math.min(book[1], endTime-1)
                });
            }
        }

        booking.add(new int[]{startTime, endTime-1});
        return true;

    }

    public boolean isOverlaping(int[] book, int s2, int e2){
        int s1 = book[0], e1 = book[1];
        return e2 >= s1 && e1 >= s2;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */