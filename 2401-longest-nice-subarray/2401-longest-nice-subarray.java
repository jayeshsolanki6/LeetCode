class Solution {
    public int longestNiceSubarray(int[] nums) {
        // int len = nums.length;
        // if(len == 1) return 1;
        // int xor = nums[0], sum = nums[0];
        // int count = 1, max = 1;
        // for(int i = 1; i<len; i++){
        //     if((nums[i-1] & nums[i]) == 0){
        //         sum += nums[i];
        //         xor ^= nums[i];
        //         if(sum == xor){
        //             count++;
        //         } else{
        //             max = Math.max(max, count);
        //             count = 2;
        //             sum = nums[i] + nums[i-1];
        //             xor = nums[i] + nums[i-1];
        //         }
        //     } else{
        //         max = Math.max(max, count);
        //         count = 1;
        //         sum = nums[i];
        //         xor = nums[i];
        //     }
        //     max = Math.max(max, count);
        // }
        // return max;

        // int len = nums.length;
        // if(len == 1) return 1;
        
        // int xor = nums[0], sum = nums[0];
        // int count = 1, max = 1;
        
        // for(int i = 1; i < len; i++){
        //     // Try to extend current subarray
        //     int newSum = sum + nums[i];
        //     int newXor = xor ^ nums[i];
            
        //     if(newSum == newXor) {
        //         // Valid extension - all pairs in subarray have & = 0
        //         sum = newSum;
        //         xor = newXor;
        //         count++;
        //     } else {
        //         // Can't extend, start new subarray
        //         max = Math.max(max, count);
        //         count = 1;
        //         sum = nums[i];
        //         xor = nums[i];
        //     }
        // }
        
        // return Math.max(max, count);
        int maxLen = 1;
        
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int xor = nums[i];
            
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                xor ^= nums[j];
                
                if (sum == xor) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break; // Can't extend further from position i
                }
            }
        }
        
        return maxLen;
    }
}