class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i : nums){
        //     pq.add(i);
        //     if(pq.size() > k){
        //         pq.poll();
        //     }
        // }
        // return pq.poll();
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    int quickSelect(int[] nums, int left, int right, int target){
        if(left == right) return nums[left];
        
        int mid = (left + right)/2;
        int pivot = nums[mid];
        int i = left - 1, j = right + 1;
        while(i < j){
            while(nums[++i] < pivot);
            while(nums[--j] > pivot);
            
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if(j < target){
            return quickSelect(nums, j + 1, right, target);
        }
        return quickSelect(nums, left, j, target);

    }
}