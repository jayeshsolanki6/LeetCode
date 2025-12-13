class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> res = new ArrayList<>();
        List<String> elec = new ArrayList<>();
        List<String> gro = new ArrayList<>();
        List<String> phar = new ArrayList<>();
        List<String> rest = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);
        int len = code.length;
        String[] bl = new String[]{"electronics", "grocery", "pharmacy", "restaurant"};
        for(int i = 0; i<len; i++){
            if(!isActive[i]) continue;
            String s = businessLine[i];
            boolean flag = false;
            int cl = 0;
            for(String b : bl){
                if(s.equals(b)){
                    flag = true;
                    cl = map.get(b);
                    break;
                }
            }
            if(!flag) continue;
            boolean isVal = code[i].matches("^\\w+$");
            if(isVal){
                if(cl == 0) elec.add(code[i]);
                else if(cl == 1) gro.add(code[i]);
                else if(cl == 2) phar.add(code[i]);
                else rest.add(code[i]);
            }
        }
        Collections.sort(elec);
        Collections.sort(gro);
        Collections.sort(phar);
        Collections.sort(rest);
        res.addAll(elec);
        res.addAll(gro);
        res.addAll(phar);
        res.addAll(rest);
        return res;
    }
}