class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int i = 0; i<len; i++){
            pq.add(new int[]{i, ratings[i]});
        }

        int[] candies = new int[len];
        Arrays.fill(candies, -1);

        while(!pq.isEmpty()){
            int min = pq.remove()[0];
            if(candies[min] != -1) continue;

            candies[min] = 1;
            int l = min-1;
            int r = min+1;

            while(l >= 0 && ratings[l] > ratings[l+1] && (candies[l] == -1 || candies[l] <= candies[l+1])){
                candies[l] = candies[l+1]+1;
                l--;
            }
            while(r < len && ratings[r] > ratings[r-1] && (candies[r] == -1 || candies[r] <= candies[r-1])){
                candies[r] = candies[r-1]+1;
                r++;
            }
        }
        
        int sum = 0;
        for(int c : candies) sum += c;

        return sum;
    }

}