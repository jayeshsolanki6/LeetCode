class TaskManager {
    Map<Integer, List<Integer>> map = new HashMap<>();
    TreeSet<Integer> set = new TreeSet<>((a, b) -> {
        List<Integer> l1 = map.get(a);
        List<Integer> l2 = map.get(b);
        if(l1.get(2) == l2.get(2)) return l2.get(1) - l1.get(1);
        return l2.get(2) - l1.get(2);
    });
    public TaskManager(List<List<Integer>> tasks) {
        int len = tasks.size();
        for(int i = 0; i<tasks.size(); i++){
            List<Integer> list = tasks.get(i);
            int taskId = list.get(1);
            map.put(taskId, list);
            set.add(taskId);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, Arrays.asList(userId, taskId, priority));
        set.add(taskId);
    }
    
    public void edit(int taskId, int newPriority) {
        set.remove(taskId);
        List<Integer> list = map.get(taskId);
        list.set(2, newPriority);
        set.add(taskId);
    }
    
    public void rmv(int taskId) {
        set.remove(taskId);
        map.remove(taskId);
    }
    
    public int execTop() {
        if(set.isEmpty()) return -1;
        int first = set.pollFirst();
        int userId = map.get(first).get(0);
        map.remove(first);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */