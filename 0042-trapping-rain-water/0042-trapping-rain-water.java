class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftLargest = new int[len];
        int[] rightLargest = new int[len];
        int temp = 0;
        for(int i = 0; i<len; i++){
            leftLargest[i] = temp;
            temp = Math.max(temp, height[i]);
        }
        temp = 0;
        for(int i = len-1; i>=0; i--){
            rightLargest[i] = temp;
            temp = Math.max(temp, height[i]);
        }

        int sum = 0;
        for(int i = 0; i<len; i++){
            if(leftLargest[i] <= height[i] || rightLargest[i] <= height[i]){
                continue;
            }
            sum += Math.min(leftLargest[i], rightLargest[i]) - height[i];
        }

        return sum;
    }
}