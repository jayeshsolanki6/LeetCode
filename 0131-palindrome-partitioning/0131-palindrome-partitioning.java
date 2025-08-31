class Solution {
    List<List<String>> list = new ArrayList<>();
    String s;
    int len;
    public List<List<String>> partition(String s) {
        this.s = s;
        len = s.length();
        helper(0, new ArrayList<>());
        return list;
    }
    void helper(int ind, ArrayList<String> li){
        if(ind == len){
            list.add(new ArrayList<>(li));
            return;
        }

        for(int i = ind; i<len; i++){
            if(isPal(ind, i)){
                li.add(s.substring(ind, i+1));
                helper(i+1, li);
                li.remove(li.size() - 1);
            }
        }
    }
    boolean isPal(int str, int end){
        if(str == end) return true;
        while(str < end){
            if(s.charAt(str) != s.charAt(end)){
                return false;
            }
            str++;
            end--;
        }
        return true;
    }
}