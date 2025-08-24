class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len-1);
        return count;
    }
    void mergeSort(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = (low + high)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);

        merge(nums, low, mid, high);
    }
    void merge(int[] nums, int low, int mid, int high){
        List<Integer> list = new ArrayList<>();
        int j = mid+1;
        for(int i = low; i<mid+1; i++){
            while(j <= high && nums[i] > 2*nums[j]) j++;
            count += (j - (mid+1));
        }
        int n = low, m = mid+1;
        while(n <= mid && m <= high){
            if(nums[n] > nums[m]){
                list.add(nums[m]);
                m++;
            } else{
                list.add(nums[n]);
                n++;
            }
        } 
        while(n <= mid){
            list.add(nums[n]);
            n++;
        }
        while(m <= high){
            list.add(nums[m]);
            m++;
        }
        for(int i = low; i<=high; i++){
            nums[i] = list.get(i-low);
        }
    }
}