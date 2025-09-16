class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        int i = 0, j = 1;
        while(j < list.size()){
            if(i == -1){
                i++; j++;
                continue;
            }
            int gcd = gcd(list.get(i), list.get(j));
            if(gcd > 1){
                int lcm = (list.get(i)/gcd)*list.get(j);
                list.set(i, lcm);
                list.remove(j);
                i--; j--;
            }else{
                i++; j++;
            }
        }
        return list;
    }
    int gcd(int n, int m){
        if(n == 0 || m == 0) return m+n;
        return gcd(m%n, n);
    }
}