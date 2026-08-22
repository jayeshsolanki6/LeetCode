class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];

        for(char c : tasks){
            hash[c-65]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i = 0; i<26; i++){
            if(hash[i] > 0){
                pq.add(hash[i]);
            }
        }

        int res = 0;

        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<n+1; i++){
                if(!pq.isEmpty()){
                    int freq = pq.remove();
                    freq--;
                    list.add(freq);
                }
            }

            for(int f : list){
                if(f > 0) pq.add(f);
            }

            if(pq.isEmpty()){
                res += list.size();
            } else{
                res += n+1;
            }
        }

        return res;
    }
}