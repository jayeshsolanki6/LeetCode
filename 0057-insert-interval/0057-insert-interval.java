class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if(len == 0){
            return new int[][]{newInterval};
        }
        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;
        while(i < len && intervals[i][0] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        if(list.size() != 0 && list.get(list.size()-1)[1] >= newInterval[0]){
            int[] last = list.get(list.size()-1);
            last[1] = Math.max(last[1], newInterval[1]);
            list.set(list.size()-1, last);
        } else{
            list.add(newInterval);
        }

        while(i < len){
            int[] next = intervals[i];
            if(list.get(list.size()-1)[1] >= next[0]){
                int[] last = list.get(list.size()-1);
                last[1] = Math.max(last[1], next[1]);
                list.set(list.size()-1, last);
            } else{
                list.add(next);
            }
            i++;
        }
        return list.toArray(new int[list.size()][]);

    }
}