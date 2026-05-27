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
        
        ArrayList<Integer>[] list = new ArrayList[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(list[freq] == null){
                list[freq] = new ArrayList<>();
            }
            list[freq].add(key);
        }

        int[] res = new int[k];

        int i = 0;

        for(int j = nums.length; j>0; j--){
            if(list[j] != null){
                for(int num : list[j]){
                    res[i++] = num;
                    if(i == k) return res;
                }
            }
        }
        return res;
    }
}