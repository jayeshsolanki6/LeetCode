class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : nums){
            pq.add(i);
        }
        for(int i = 1; i<k; i++){
            pq.poll();
        }
        return pq.poll();
    }
}