class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for(int index=0;index<strs.length;index++) {
            String value = strs[index];

            char[] key = value.toCharArray();
            Arrays.sort(key);

            String sortedKey = new String(key);

            if(result.get(sortedKey)==null) {
                List<String> values = new ArrayList<>();
                values.add(value);
                result.put(sortedKey, values);
            } else {
                List<String> values = result.get(sortedKey);
                values.add(value);
                result.put(sortedKey, values);
            }
        }

        List<List<String>> finalResult = new ArrayList<>();

        for(List<String> list : result.values()) {
            finalResult.add(list);
        }

        return finalResult;
        
    }
}
