class Solution {
    public int minMutation(String s, String e, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Set<String> vis = new HashSet<>();

        char[] rep = {'A', 'C', 'G', 'T'};
        for(String str : bank) bankSet.add(str);
        vis.add(s);

        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        int counter = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String str = q.remove();
                if(str.equals(e)) return counter;

                StringBuilder sb = new StringBuilder(str);

                for(int i = 0; i<8; i++){
                    char temp = sb.charAt(i);
                    for(char c : rep){
                        if(c == temp) continue;
                        sb.setCharAt(i, c);
                        String newStr = sb.toString();
                        if(bankSet.contains(newStr) && !vis.contains(newStr)){
                            q.add(newStr);
                            vis.add(newStr);
                        }
                    }
                    sb.setCharAt(i, temp);
                }
            }
            
            counter++;
        }

        return -1;
    }
}