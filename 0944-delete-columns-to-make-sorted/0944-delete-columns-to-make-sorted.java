class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs.length;
        int n = strs[0].length();
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 1; j<len; j++){
                if(strs[j-1].charAt(i) > strs[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}