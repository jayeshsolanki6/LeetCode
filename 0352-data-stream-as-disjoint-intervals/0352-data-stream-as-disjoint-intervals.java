class SummaryRanges {
    TreeMap<Integer, Integer> map;
    Set<Integer> set = new HashSet<>();

    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if(set.contains(value)) return;
        set.add(value);
        Integer floor = map.floorKey(value);
        Integer ceil = map.ceilingKey(value);
        if(floor == null && ceil == null){
            map.put(value, value);
        } else if(floor == null){
            if(value+1 == ceil){
                map.put(value, map.get(ceil));
                map.remove(ceil);
            } else{
                map.put(value, value);
            }
        } else if(ceil == null){
            if(map.get(floor)+1 == value){
                map.put(floor, value);
            } else{
                map.put(value, value);
            }
        } else{
            int left = map.get(floor);
            int right = ceil;
            if(left+1 == value && value+1 == right){
                map.put(floor, map.get(ceil));
                map.remove(ceil);
            } else if(left+1 == value){
                map.put(floor, value);
            } else if(value+1 == right){
                map.put(value, map.get(ceil));
                map.remove(ceil);
            } else {
                map.put(value, value);
            }
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][];
        int i = 0;
        for(int key : map.keySet()){
            res[i++] = new int[]{key, map.get(key)};
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */