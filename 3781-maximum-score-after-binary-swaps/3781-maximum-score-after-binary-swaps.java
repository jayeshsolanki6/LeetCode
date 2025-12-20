class Solution {
    public long maximumScore(int[] nums, String s) {
        int len = nums.length;
        char[] arr = s.toCharArray();
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<len; i++){
            pq.add(nums[i]);
            if(arr[i] == '1'){
                ans += pq.remove();
            }
        }
        return ans;
    }
}