class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int len = target[target.length-1];
        for(int i : target){
            set.add(i);
        }
        for(int i = 1; i<=len; i++){
            if(set.contains(i)){
                list.add("Push");
            } else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}