class SummaryRanges {
    int[] parent;
    public SummaryRanges() {
        parent = new int[10001];
        Arrays.fill(parent, -1);
    }
    
    public void addNum(int value) {
        if(parent[value] != -1) return;
        parent[value] = value;
    }
    
    public int[][] getIntervals() {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i<10001; i++){
            if(parent[i] != -1){
                int x = findUP(i);
                list.add(new int[]{i, x});
                i = x+1;
            }
        }
        int[][] res = list.toArray(new int[0][]);
        return res;
    }

    int findUP(int x){
        if(x == 10001 || parent[x] == -1) return -1;
        int next = -1;
        if(parent[x] >= x){
            next = findUP(x+1);
        }
        if(next == -1) return parent[x];
        return parent[x] = next;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */