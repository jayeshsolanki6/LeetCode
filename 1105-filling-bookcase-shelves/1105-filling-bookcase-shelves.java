class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        HashMap<String, Integer> dp = new HashMap<>(); 
        return find(0, 0, shelfWidth, books, len, dp);
    }

    int find(int i, int shelf, int width, int[][] books, int len, HashMap<String, Integer> dp){
        if(i == len) return 0;

        String s = i + "" + shelf;
        if(dp.containsKey(s)) return dp.get(s);

        int minH = Integer.MAX_VALUE;
        int h = 0;
        int w = 0;
        int temp = i;
        while(i < len && (w + books[i][0] <= width)){
            w += books[i][0];
            h = Math.max(h, books[i][1]);
            i++;
            minH = Math.min(minH, h + find(i, shelf+1, width, books, len, dp));
        }
        dp.put(s, minH);
        return minH;
    }
}