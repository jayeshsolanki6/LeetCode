class Spreadsheet {
    Map<String, Integer> map = new HashMap<>();

    public Spreadsheet(int rows) {
        for(int i = 1; i<=rows; i++){
            char a = 'A';
            for(int j = 0; j<26; j++){
                String s = "" + a + i;
                map.put(s, 0);
                a++;
            }
        }
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] s = formula.substring(1, formula.length()).split("\\+");
        int ans = 0;
        if(map.containsKey(s[0])){
            ans += map.get(s[0]);
        } else{
            ans += Integer.parseInt(s[0]);
        }
        if(map.containsKey(s[1])){
            ans += map.get(s[1]);
        } else{
            ans += Integer.parseInt(s[1]);
        }
        return ans;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */