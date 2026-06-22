class Solution {
    int[][] tree;
    public List<Integer> fallingSquares(int[][] positions) {
        //Coordinate compression
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] pos : positions){
            set.add(pos[0]);
            set.add(pos[0] + pos[1] - 1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 0;
        for(int num : set){
            map.put(num, n++);
        }

        //solution start

        tree = new int[4*n][2];
        for(int i = 0; i<4*n; i++){
            tree[0][1] = -1;
        }
        //tree[][0] = max, tree[][1] = lazy

        List<Integer> res = new ArrayList<>();

        for(int[] pos : positions){
            int l = map.get(pos[0]);
            int r = map.get(pos[0] + pos[1] - 1);
            int val = pos[1];
            int currMax = query(0, 0, n-1, l, r);
            update(0, 0, n-1, l, r, currMax + val);
            res.add(tree[0][0]);
        }
        return res;
    }
    void push(int id, int l, int r){
        if(tree[id][1] != -1){
            tree[id][0] = tree[id][1];
            if(l != r){
                tree[id*2+1][1] = tree[id][1];
                tree[id*2+2][1] = tree[id][1];
            }
            tree[id][1] = -1;
        }
    }
    int query(int id, int l, int r, int lq, int rq){
        push(id, l, r);
        if(r < lq || l > rq) return 0;
        if(lq <= l && r <= rq){
            return tree[id][0];
        }
        int mid = (l+r)>>1;
        return Math.max(
            query(id*2+1, l, mid, lq, rq),
            query(id*2+2, mid+1, r, lq, rq)
        );
    }
    void update(int id, int l, int r, int lq, int rq, int val){
        push(id, l, r);
        if(r < lq || l > rq) return;
        if(lq <= l && r <= rq){
            tree[id][1] = val;
            push(id, l, r);
            return;
        }
        int mid = (l+r)>>1;
        update(id*2+1, l, mid, lq, rq, val);
        update(id*2+2, mid+1, r, lq, rq, val);
        tree[id][0] = Math.max(tree[id*2+1][0], tree[id*2+2][0]);
    }
}