class Node{
    int key;
    int val;
    int freq;
    Node next,prev;
    Node(int key,int val){
        this.freq=1;
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}

class DLL{
    Node head;
    Node tail;
    int len;
    DLL(){
        this.len=0;
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=tail;
        this.tail.prev=head;
    }
}
class LFUCache {
    int capacity;
    int minFreq;
    Map<Integer,Node> cache;  //{key:Node}
    Map<Integer, DLL> frequency;   //{frquency:DLL}

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
        this.cache=new HashMap<>();
        this.frequency=new HashMap<>();
    }
    public void remove(DLL dll,Node node){
        dll.len--;
        Node front=node.next;
        Node back=node.prev;
        back.next=front;
        front.prev=back;
    }

    public void addAtStart(DLL dll,Node node){
        dll.len++;
        Node front=dll.head.next;
        dll.head.next=node;
        node.next=front;
        node.prev=dll.head;
        front.prev=node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            DLL olddll=frequency.get(node.freq);
            node.freq++;
            remove(olddll,node);
            if(olddll.len==0){ 
                if(minFreq==(node.freq-1)) minFreq++;
                frequency.remove(node.freq-1);
            }
            DLL newdll=frequency.getOrDefault(node.freq , new DLL());
            addAtStart(newdll,node);
            frequency.put(node.freq, newdll);
            return node.val;
        }else return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            DLL olddll=frequency.get(node.freq);
            node.freq++;
            node.val=value;
            remove(olddll,node);
            if(olddll.len==0){ 
                if(minFreq==(node.freq-1)) minFreq++;
                frequency.remove(node.freq-1);
            }
            DLL newdll=frequency.getOrDefault(node.freq , new DLL());
            addAtStart(newdll,node);
            frequency.put(node.freq, newdll);
        }else{
            Node newnode=new Node(key,value);
            if(capacity==cache.size()){
                DLL dll=frequency.get(minFreq);
                cache.remove(dll.tail.prev.key);
                remove(dll,dll.tail.prev);
                if(dll.len==0){ 
                    frequency.remove(minFreq);
                }
            }
            cache.put(key,newnode);
            DLL newdll=frequency.getOrDefault(1, new DLL());
            addAtStart(newdll,newnode);
            frequency.put(1, newdll);
            minFreq=1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */