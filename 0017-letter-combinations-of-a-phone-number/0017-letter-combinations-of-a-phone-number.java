class Solution {
    List<String> list = new ArrayList<>();
    String[] arr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int len;

    public List<String> letterCombinations(String digits) {
        len = digits.length();
        if(len == 0) return list;
        generate(digits, 0, new StringBuilder());
        return list;
    }
    void generate(String digits, int ind, StringBuilder sb){
        if(ind == len){
            list.add(sb.toString());
            return;
        }
        int n = digits.charAt(ind) - '0';
        for(char c : arr[n].toCharArray()){
            StringBuilder str = new StringBuilder();
            str.append(sb).append(c);
            generate(digits, ind+1, str);
        }
    }
}