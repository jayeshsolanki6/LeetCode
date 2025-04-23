class Solution {
    public int countLargestGroup(int n) {
        int[] arr = new int[37];
        for(int i = 1; i<=n; i++){
            int k = sum(i);
            arr[k]++;
        }
        int max = 0;
        for(int val: arr){
            if(val>max){
                max = val;
            }
        }
        int count = 0;
        for (int val : arr) {
            if (val == max) {
            count++;
            }
        }
        return count;


        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i = 1; i<=n; i++){
        //     int k = sum(i);
        //     map.put(k, map.getOrDefault(k, 0) + 1);
        // }
        // int max = Collections.max(map.values());
        // int count = 0;
        // for(Integer a : map.values()){
        //     if(a == max){
        //         count++;
        //     }
        // }
        // return count;
    }
    public static int sum(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}