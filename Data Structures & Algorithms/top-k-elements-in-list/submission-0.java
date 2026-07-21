class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        
        List<Integer> result = freqMap.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue() - a.getValue())
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
