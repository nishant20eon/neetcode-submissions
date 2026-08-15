class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        } else {
            Map.Entry<Integer, String> entry =  map.get(key).floorEntry(timestamp);

            if(entry==null) {
                return "";
            }
            return entry.getValue();
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */