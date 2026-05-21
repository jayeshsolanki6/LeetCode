class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int a = arr1.length;
        int b = arr2.length;

        Set<Integer> set = new HashSet<>();

        for(int num : arr1){
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }

        int max = 0;

        for(int num : arr2){
            while(num > 0){
                if(set.contains(num)){
                    max = Math.max(max, String.valueOf(num).length());
                    break;
                }
                num /= 10;
            }
        }

        return max;
    }
}