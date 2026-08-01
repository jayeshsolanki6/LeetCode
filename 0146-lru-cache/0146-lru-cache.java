class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
            return;
        }
        if(map.size() == cap){
            deleteLRU();
        }
        Node newNode = new Node(key, value);
        add(newNode);
        map.put(key, newNode);
    }

    private void deleteLRU(){
        map.remove(tail.prev.key);
        Node temp = tail.prev.prev;
        temp.next = tail;
        tail.prev = temp;
    }
    private void add(Node newNode){
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */