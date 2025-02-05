class Node {
    int key;
    int val;
    Node next, prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void remove(Node node){
        Node front=node.next;
        Node back=node.prev;
        back.next=front;
        front.prev=back;
    }

    public void addAtStart(Node node){
        Node front=head.next;
        head.next=node;
        node.next=front;
        node.prev=head;
        front.prev=node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node=cache.get(key);
            remove(node);
            addAtStart(node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            remove(node);
            addAtStart(node);
        } else {
            Node newnode = new Node(key, value);
            if (capacity == 0) {
                cache.remove(tail.prev.key);
                remove(tail.prev); // removing least recently used
                addAtStart(newnode);
                cache.put(key, newnode);
            }else{
                capacity--;
                addAtStart(newnode);
                cache.put(key,newnode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */