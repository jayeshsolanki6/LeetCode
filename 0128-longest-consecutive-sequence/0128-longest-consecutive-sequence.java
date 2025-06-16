class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        // Arrays.sort(nums);
        if(len<=1) return len;
        // int max = 1, count = 1;
        // for(int i = 0; i<len-1; i++){
        //     if(nums[i] + 1 == nums[i+1]){
        //         count++;
        //         max = Math.max(max,count);
        //     } else if(nums[i] == nums[i+1]){
        //         continue;
        //     } else{
        //         count = 1;
        //     }
        // }
        // return max;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<len; i++){
            set.add(nums[i]);
        }
        int max = 1;
        for(int s: set){
            if(!set.contains(s-1)){
                int x = s;
                int count = 1;
                while(set.contains(x+1)){
                    x = x+1;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}