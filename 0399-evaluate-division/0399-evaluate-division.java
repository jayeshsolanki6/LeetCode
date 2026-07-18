class Solution {
    class Pair {
        String s;
        double d;
        Pair(String s, double d){
            this.s = s;
            this.d = d;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Set<Pair>> map = new HashMap<>();
        int len = equations.size();

        for(int i = 0; i<len; i++){
            List<String> eq = equations.get(i);
            if(!map.containsKey(eq.get(0))) map.put(eq.get(0), new HashSet<>());
            if(!map.containsKey(eq.get(1))) map.put(eq.get(1), new HashSet<>());

            map.get(eq.get(0)).add(new Pair(eq.get(1), values[i]));
            map.get(eq.get(1)).add(new Pair(eq.get(0), 1/values[i]));
        }

        int qlen = queries.size();
        double[] res = new double[qlen];

        for(int i = 0; i<qlen; i++){
            List<String> eq = queries.get(i);
            if(!map.containsKey(eq.get(0)) || !map.containsKey(eq.get(1))){
                res[i] = -1.0;
                continue;
            }
            res[i] = getRes(eq.get(0), eq.get(1), map, new HashSet<>());
        }

        return res;
    }

    double getRes(String s1, String s2, Map<String, Set<Pair>> map, Set<String> vis){
        if(vis.contains(s1)) return -1;
        vis.add(s1);

        Set<Pair> adj = map.get(s1);
        for(Pair p : adj){
            if(s2.equals(p.s)) return p.d;
            double res = getRes(p.s, s2, map, vis);
            if(res > 0) return p.d*res;
        }

        return -1.0;
    }
}