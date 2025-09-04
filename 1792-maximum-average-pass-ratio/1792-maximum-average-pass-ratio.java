class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );
        for(int[] cls : classes){
            pq.add(cls);
        }
        while(extraStudents-- > 0){
            int[] cls = pq.remove();
            cls[0]++;
            cls[1]++;
            pq.add(cls);
        }
        double d = 0;
        int size = pq.size();
        while(!pq.isEmpty()){
            int[] cls = pq.remove();
            d += (double)cls[0]/cls[1]; 
        }
        return d/size;
    }
    double gain(int a, int b){
        double g = (double)(b-a)/((double)b*(b+1));
        return g;
    }
    
}