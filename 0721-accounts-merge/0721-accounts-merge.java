class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        parent = new int[len];
        for(int i = 0; i<len; i++) parent[i] = i;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i<len; i++){
            List<String> list = accounts.get(i);
            int size = list.size();
            for(int j = 1; j<size; j++){
                String s = list.get(j);
                if(map.containsKey(s)){
                    union(map.get(s), i);
                } else{
                    map.put(s, i);
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();

        for(int i = 0; i<len; i++){
            mergedMail.add(new ArrayList<>());
        }

        for(String s : map.keySet()){
            int node = findUPar(map.get(s));
            mergedMail.get(node).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i<len; i++){
            List<String> mails = mergedMail.get(i);
            Collections.sort(mails);
            if(mails.size() == 0) continue;
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(String str : mails){
                list.add(str);
            }
            result.add(list);
        }

        return result;


    }

    int findUPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findUPar(parent[n]);
    }

    void union(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);

        if(pu != pv){
            parent[pu] = pv;
        }
    }
}