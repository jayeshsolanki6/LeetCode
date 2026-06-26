class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for(int i = 0; i<len;){
            int sum = 0;
            for(int j = 0; j<len; j++){
                int ind = (i+j)%len;
                sum += gas[ind];
                if(sum >= cost[ind]){
                    sum -= cost[ind];
                } else{
                    i += j+1;
                    break;
                }
                if(j == len-1) return i;
            }
        }

        return -1;
    }
}