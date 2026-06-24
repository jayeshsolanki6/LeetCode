class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;

        for(int i = 0; i<len; i++){
            if(len-i <= citations[i]) return len-i;
        }

        return 0;
    }
}