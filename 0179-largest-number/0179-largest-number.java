class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int al = a.length();
            int bl = b.length();
            int i = 0, j = 0;
            while(i < al || j < bl){
                if(i == al) i = 0;
                if(j == bl) j = 0;
                if(a.charAt(i) < b.charAt(j)){
                    return 1;
                } else if(a.charAt(i) > b.charAt(j)){
                    return -1;
                }
                i++; j++;
            }
            return (al > bl) ? 1 : -1;
        });

        for(int i : nums){
            pq.add("" + i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.remove());
        }
        if(sb.toString().matches("0+")) return "0";
        return sb.toString();
    }
}