class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer,Integer> lhm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lhm = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return lhm.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        
        lhm.put(key,value);
    }
}
