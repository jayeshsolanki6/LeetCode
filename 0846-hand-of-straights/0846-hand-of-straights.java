class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        if(hand.length % k != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0)+1);
            set.add(i);
        }

        while(!set.isEmpty()){
            int min = set.pollFirst();
            int size = map.get(min);
            for(int i = 0; i<k; i++){
                int el = min+i;
                if(!map.containsKey(el)) return false;
                int elsize = map.get(el);
                if(size > elsize){
                    return false;
                } else if(size == elsize){
                    map.remove(el);
                    set.remove(el);
                } else{
                    map.put(el, elsize-size);
                }
            }
        }
        return true;
    }
}