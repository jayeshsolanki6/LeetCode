class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        int len = healths.length;
        Integer[] ind = new Integer[len];
        for(int i = 0; i<len; i++){
            ind[i] = i;
        }
        Arrays.sort(ind, (a, b) -> (positions[a] - positions[b]));

        Stack<Integer> st = new Stack<>();
        for(int i : ind){
            if(dir.charAt(i) == 'R'){
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && healths[i] > 0){
                int topInd = st.pop();
                if(healths[topInd] > healths[i]){
                    healths[i] = 0;
                    healths[topInd]--;
                    st.push(topInd);
                } else if(healths[topInd] < healths[i]){
                    healths[topInd] = 0;
                    healths[i]--;
                } else{
                    healths[topInd] = 0;
                    healths[i] = 0;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<len; i++){
            if(healths[i] > 0){
                list.add(healths[i]);
            }
        }
        return list;
    }
}