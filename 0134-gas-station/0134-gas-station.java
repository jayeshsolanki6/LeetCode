class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int gasSum = 0, costSum = 0;
        for(int i = 0; i<len; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum) return -1;

        int cargas = 0, start = 0;
        for(int i = 0; i<len; i++){
            cargas += gas[i] - cost[i];
            if(cargas < 0){
                start = i+1;
                cargas = 0;
            }
        }

        return start;
    }
}