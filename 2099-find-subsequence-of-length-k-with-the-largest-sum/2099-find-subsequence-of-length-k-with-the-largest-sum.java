class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        Integer[] ind = new Integer[len];
        for(int i = 0; i<len; i++){
            ind[i] = i;
        }
        Arrays.sort(ind, (a,b) -> nums[b]-nums[a]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<k; i++){
            pq.add(ind[i]);
        }
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = nums[pq.remove()];
        }
        return res;
    }
}