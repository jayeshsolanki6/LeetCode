class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for(int i : apple) total += i;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : capacity) pq.add(i);
        int count = 0;
        while(total>0){
            total -= pq.remove();
            count++;
        }
        return count;
    }
}