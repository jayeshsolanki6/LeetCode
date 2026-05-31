class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;

        int sum = len;
        int i = 1;

        while(i < len){
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }

            int peek = 0;
            while(i < len && ratings[i] > ratings[i-1]){
                sum += ++peek;
                i++;
            }
            int down = 0;
            while(i < len && ratings[i] < ratings[i-1]){
                sum += ++down;
                i++;
            }

            sum -= Math.min(peek,down);

        }

        return sum;
    }

}