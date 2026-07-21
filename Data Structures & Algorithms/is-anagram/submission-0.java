class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // base case
        if(s.length()!=t.length()) return false;
        
        // appending character with its length
        for(int i =0; i<s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i =0; i<t.length(); i++) {
            // if(map.containsKey(t.charAt(i))) {

            // }
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }

        if( map1.equals(map2)) {
            return true;
        } else {
             return false;
        }

    }
}
