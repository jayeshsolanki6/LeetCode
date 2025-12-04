class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<len; i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min, i-map.get(nums[i]));
            }
            int rev = reverse(nums[i]);
            map.put(rev, i);
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
        
    }
    int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev*10 + num%10;
            num /= 10;
        }
        return rev;
    }
}