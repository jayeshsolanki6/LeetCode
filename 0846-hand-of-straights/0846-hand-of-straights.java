class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        if(nums.length % k != 0) return false;

        for(int i = 0; i<len; i++){
            if(nums[i] != -1){
                if(!findSuccessor(i, nums, k, len)) return false;
            }
        }

        return true;
    }

    boolean findSuccessor(int ind, int[] nums, int k, int len){
        int nextFind = nums[ind]+1;
        nums[ind++] = -1;
        int count = 1;

        while(ind < len && count < k){
            if(nums[ind] == nextFind){
                nums[ind] = -1;
                nextFind++;
                count++;
            }
            ind++;
        }
        if(count == k) return true;
        return false;
    }
}