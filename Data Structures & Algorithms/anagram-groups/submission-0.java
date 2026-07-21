class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(String str: strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                set.add(new String(chars));
        }

        for(String str1: set) {
                List<String> sublist = new ArrayList<>();
            for(String str2: strs) {
                char[] chars2 = str2.toCharArray();
                Arrays.sort(chars2);
                if(str1.equals(new String(chars2))) {
                    sublist.add(str2);
                }

            }
            list.add(sublist);
        }
        return list;
        
    }
}
