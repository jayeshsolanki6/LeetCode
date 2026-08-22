class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b+a).compareTo(a+b));

        for(int i : nums){
            pq.add(String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.remove());
        }
        if(sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}