class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<len; i++){
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            if(q.getFirst() < i-k+1) q.removeFirst();
            if(i >= k-1){
                res[i-k+1] = nums[q.getFirst()];
            }
        }

        return res;
    }
}