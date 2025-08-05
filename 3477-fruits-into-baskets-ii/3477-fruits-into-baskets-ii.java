class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int len = fruits.length;
        boolean[] bas = new boolean[len];
        for(int i : fruits){
            for(int j = 0; j<len; j++){
                if(!bas[j] && baskets[j] >= i){
                    bas[j] = true;
                    break;
                }
            }

        }
        int count = 0;
        for(boolean b : bas){
            if(!b) count++;
        }
        return count;
    }
}