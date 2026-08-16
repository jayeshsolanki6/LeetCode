class Solution {
    public int minOperations(String s) {
        int len = s.length();
        String str = s + s;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i<len; i++){
            min = Math.min(min, opToMakePali(i, i+len-1, str) + i);
        }
        return min;
    }
    int opToMakePali(int i, int j, String s){
        int cost = 0;
        while(i < j){
            int a = s.charAt(i), b = s.charAt(j);
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            cost += Math.min(max-min, min + 26 - max);
            i++; j--;
        }
        return cost;
    }
}