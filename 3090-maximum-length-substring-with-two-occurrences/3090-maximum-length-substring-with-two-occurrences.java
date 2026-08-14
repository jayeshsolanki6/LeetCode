class Solution {
    public int maximumLengthSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] hash = new int[26];

        int max = 0;
        int l = 0;
        for(int r = 0; r<len; r++){
            int i = arr[r]-97;
            hash[i]++;

            while(hash[i] > 2){
                hash[arr[l]-97]--;
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}