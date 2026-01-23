class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        memo = new int[len];
        Arrays.fill(memo, -1);
        return Math.min(calculate(cost, 0, len), calculate(cost, 1, len));
    }
    int calculate(int[] cost, int index, int len){
        if(index>=len) return 0;
        if(index == len-1) return cost[index];
        if(memo[index] != -1) return memo[index];

        int minCost = cost[index] + Math.min(calculate(cost, index+1, len), calculate(cost, index+2, len));
        memo[index] = minCost;
        return minCost;
    }
}