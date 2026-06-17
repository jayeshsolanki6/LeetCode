class NumArray {
    int n;
    int[] arr;
    int[] tree;

    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums;
        tree = new int[4*n];
        build(0, 0, n-1);
    }
    
    public void build(int id, int l, int r){
        if(l == r){
            tree[id] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2*id+1, l, mid);
        build(2*id+2, mid+1, r);
        tree[id] = tree[2*id+1] + tree[2*id+2];
    }

    public void update(int index, int val) {
        update(0, 0, n-1, index, val);
    }
    
    public void update(int id, int l, int r, int pos, int val){
        if(pos < l || pos > r) return;
        if(l == r){
            tree[id] = val;
            arr[l] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        update(2*id+1, l, mid, pos, val);
        update(2*id+2, mid+1, r, pos, val);
        tree[id] = tree[2*id+1] + tree[2*id+2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n-1, left, right);
    }

    public int query(int id, int l, int r, int lq, int rq){
        if(l > rq || r < lq) return 0;
        if(l >= lq && r <= rq) return tree[id];
        int mid = l + (r - l) / 2;
        return query(2*id+1, l, mid, lq, rq) + query(2*id+2, mid+1, r, lq, rq);
    }
}