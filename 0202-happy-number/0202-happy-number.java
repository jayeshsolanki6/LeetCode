class Solution {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int num = 0;
            while(n > 0){
                int rem = n%10;
                num += rem*rem;
                n = n/10;
            }
            if(num == 1) return true;
            n = num;
        }
        return false;
    }
}