class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int arr[] = new int[len];
        for(int i = 0; i<len; i++){
            arr[i] = 0;
            for(int j = 0; j<len; j++){
                if(i == j) continue;
                if(boxes.charAt(j) == '1'){
                    arr[i] += Math.abs(i-j);
                }
            }
        }
        return arr;
    }
}