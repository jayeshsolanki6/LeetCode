class Solution {
    public int countCollisions(String directions) {
        int hit = 0;
        Stack<Character> st = new Stack<>();
        for(char c : directions.toCharArray()){
            if(st.isEmpty() && c == 'L') continue; 
            if(st.isEmpty() || c == 'R') {
                st.push(c);
                continue;
            }
            if(c == 'L'){
                if(st.peek() == 'R'){
                    hit += 2;
                    st.pop();
                    while(!st.isEmpty() && st.peek() == 'R'){
                        hit += 1;
                        st.pop();
                    }
                    st.push('S');
                }
                else if(st.peek() == 'S'){
                    hit += 1;
                }
                else{
                    st.push(c);
                }
            } else{
                while(!st.isEmpty() && st.peek() == 'R'){
                    hit += 1;
                    st.pop();
                }
                st.push('S');
            }

        }
        return hit;
    }
}