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
            int diff = Math.abs(s.charAt(i) - s.charAt(j));
            cost += Math.min(diff, 26 - diff);
            i++; j--;
        }
        return cost;
    }
}