class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String pattern = new String(chars);
            List<String> sublist = new ArrayList<>();
            if(map.containsKey(pattern)) {
                sublist = map.get(pattern);
                sublist.add(str);
            } else {
                sublist.add(str);
                map.put(pattern, sublist);
            }
        }

        for(List<String> sublist: map.values()) {
            list.add(sublist);
        }
        return list;
    }
}
