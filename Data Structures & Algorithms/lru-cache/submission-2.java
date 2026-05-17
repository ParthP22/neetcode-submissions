class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer,Integer> lhm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lhm = new LinkedHashMap<>(capacity,1,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return this.size() >  LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return this.lhm.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        lhm.put(key,value);
    }
}
