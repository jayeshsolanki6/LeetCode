class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long total = mass;
        for(int ast : asteroids){
            if(total >= ast){
                total += ast;
                if(total > Integer.MAX_VALUE) return true;
            } else{
                return false;
            }
        }
        return true;
    }
}