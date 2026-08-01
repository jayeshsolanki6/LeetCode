class Solution {
    class Node{
        String s;
        int freq;
        Node(String s){
            this.s = s;
            freq = 1;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<Node> list = new ArrayList<>();
        Map<String, Node> map = new HashMap<>();

        for(String s : words){
            if(map.containsKey(s)){
                map.get(s).freq++;
                continue;
            }
            Node node = new Node(s);
            map.put(s, node);
            list.add(node);
        }

        Collections.sort(list, (a, b) -> (b.freq != a.freq) ? (b.freq - a.freq) : a.s.compareTo(b.s));
        List<String> res = new ArrayList<>();
        for(int i = 0; i<k; i++){
            res.add(list.get(i).s);
        }
        return res;
    }
}