class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] res = new int[len];
        int[] hash = new int[len+1];
        
        for(int i = 0; i<len; i++){
            hash[A[i]]++;
            hash[B[i]]++;
            int count = 0;
            for(int j : hash){
                if(j > 1) count++;
            }
            res[i] = count;
        }
        return res;
    }
}