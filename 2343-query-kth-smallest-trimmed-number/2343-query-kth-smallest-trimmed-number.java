class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len = nums.length;
        int n = nums[0].length();
        int ql = queries.length;

        int[] res = new int[ql];

        int[] idx = new int[1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            for(int i = idx[0]; i<n; i++){
                if(nums[a].charAt(i) != nums[b].charAt(i)){
                    return nums[b].charAt(i) - nums[a].charAt(i);
                }
            }
            return b-a;
        });

        for(int i = 0; i<ql; i++){
            idx[0] = n - queries[i][1];

            for(int j = 0; j<len; j++){
                pq.add(j);
                if(pq.size() > queries[i][0]){
                    pq.remove();
                }
            }

            res[i] = pq.remove();
            pq.clear();
        }
        return res;
    }
}