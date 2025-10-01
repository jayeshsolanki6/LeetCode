class Solution {
    public int numWaterBottles(int b, int ex) {
        int count = 0;
        int full = b, empty = 0;
        while(full > 0){
            count += full;
            empty += full;
            full = 0;
            if(empty >= ex){
                full += empty / ex;
                empty %= ex;
            }
        }
        return count;
    }
}