class Solution {
    int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a = convert(arriveAlice);
        int b = convert(leaveAlice);
        int x = convert(arriveBob);
        int y = convert(leaveBob);
        if(b < x || y < a) return 0;
        if(a < x) return Math.min(b, y) - x + 1;
        return Math.min(b, y) - a + 1;
    }
    int convert(String s){
        String[] arr = s.split("-");
        int m = Integer.parseInt(arr[0]);
        int d = Integer.parseInt(arr[1]);
        for(int i = 0; i<m-1; i++){
            d += months[i];
        }
        return d;
    }
}