class Solution {
    public long minMoves(int[] balance) {
        int len = balance.length;
        long sum = 0;
        boolean flag = true;
        int ind = 0;
        for(int i = 0; i<len; i++) {
            if(balance[i] < 0) {
                flag = false;
                ind = i;
            }
            sum += balance[i];
        }
        if(flag) return 0;
        if(sum < 0) return -1;
        int l = ind-1, r = ind+1;
        int ll = 1, rl = 1;
        long count = 0;
        while(balance[ind] < 0){
            if(l == -1) l = len-1;
            if(r == len) r = 0;
            if(balance[l] > 0){
                if(balance[l] <= Math.abs(balance[ind])){
                    balance[ind] += balance[l];
                    count += ll*balance[l];
                }else{
                    count += ll*Math.abs(balance[ind]);
                    break;
                } 
            }
            if(balance[r] > 0){
                if(balance[r] <= Math.abs(balance[ind])){
                    balance[ind] += balance[r];
                    count += rl*balance[r];
                }else{
                    count += rl*Math.abs(balance[ind]);
                    break;
                }  
            }
            l--;
            ll++;
            rl++;
            r++;
        }
        return count;
    }
}