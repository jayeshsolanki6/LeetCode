class Solution {
    int[] tree;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        tree = new int[4*n];
        for(int[] booking : bookings){
            update(0, 0, n-1, booking[0]-1, booking[1]-1, booking[2]);
        }
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            res[i] = find(0, 0, n-1, i);
        }
        return res;
    }

    public void update(int id, int l, int r, int lq, int rq, int val){
        if(r < lq || l > rq) return;
        if(l >= lq && r <= rq){
            tree[id] += val;
            return;
        } 
        int mid = (l + r)/2;
        update(2*id+1, l, mid, lq, rq, val);
        update(2*id+2, mid+1, r, lq, rq, val);
    }

    public int find(int id, int l, int r, int pos){
        if(pos < l || pos > r) return 0;
        if(l == r) return tree[id];
        int mid = (l + r)/2;
        int left = find(2*id+1, l, mid, pos);
        int right = find(2*id+2, mid+1, r, pos);
        return left + right + tree[id];
    }
}