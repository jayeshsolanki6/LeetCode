class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        int[] noOfMeetings = new int[n];
        long[] endTime = new long[n];

        // long time = 0;
        for(int[] meet : meetings){
            int room = -1;
            long minEndTime = Long.MAX_VALUE;
            int minEndTimeRoom = -1;

            for(int i = 0; i<n; i++){
                if(endTime[i] <= meet[0]){
                    room = i;
                    break;
                }
                if(endTime[i] < minEndTime){
                    minEndTime = endTime[i];
                    minEndTimeRoom = i;
                }
            }

            if(room != -1){
                endTime[room] = Math.max(endTime[room] + meet[1] - meet[0], meet[1]);
                noOfMeetings[room]++;
            } else{
                endTime[minEndTimeRoom] = Math.max(endTime[minEndTimeRoom] + meet[1] - meet[0], meet[1]);
                noOfMeetings[minEndTimeRoom]++;
            }
        }

        int max = 0;
        for(int i = 0; i<n; i++){
            if(noOfMeetings[i] > noOfMeetings[max]){
                max = i;
            }
        }

        return max;
    }
}