class Solution {
    class Pair{
        int freq, num;
        Pair(int f, int n){
            freq = f;
            num = n;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new Pair(e.getValue(), e.getKey()));
        }
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = pq.remove().num;
        }
        return res;
    }
}