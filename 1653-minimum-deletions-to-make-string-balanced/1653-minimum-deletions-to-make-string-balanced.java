class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        int[] leftB = new int[len];
        int[] rightA = new int[len];

        int c = 0;
        for(int i = 0; i<len; i++){
            leftB[i] = c;
            if(s.charAt(i) == 'b') c++;
        }
        c = 0;
        for(int i = len-1; i>=0; i--){
            rightA[i] = c;
            if(s.charAt(i) == 'a') c++;
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i<len; i++){
            res = Math.min(res, leftB[i] + rightA[i]);
        }
        return res;
    }
}

