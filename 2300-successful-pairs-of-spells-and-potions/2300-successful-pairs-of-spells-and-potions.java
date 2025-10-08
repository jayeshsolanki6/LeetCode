class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            int num = spells[i];
            int count = 0;
            for(int j = 0; j<m; j++){
                if(num * potions[j] >=  success) count++;
            }
            res[i] = count;
        }
        return res;
    }
}