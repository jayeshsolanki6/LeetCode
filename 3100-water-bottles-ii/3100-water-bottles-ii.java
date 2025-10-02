class Solution {
    public int maxBottlesDrunk(int numBottles, int ex) {
        int full = numBottles, empty = 0, count = 0;
        while(full > 0){
            count += full;
            empty += full;
            full = 0;
            while(empty >= ex){
                full++;
                empty -= ex;
                ex++;
            }
        }
        return count;
    }
}