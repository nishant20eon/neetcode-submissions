class Solution {
    public boolean isAnagram(String s, String t) {

       Map<Character, Integer> map = new HashMap<>();
        // base case
        if(s.length()!=t.length()) return false;
        
        // appending character with its length
        for(int i =0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i =0; i<t.length(); i++) { 
            char c =  t.charAt(i);
            if(map.containsKey(c)) {
                int a = map.get(c)-1;
                if(a==0) {
                    map.remove(c);
                } else {
                    map.put(c, a);
                }
            }
        }

        if( map.isEmpty()) {
            return true;
        } else {
             return false;
        }

    }
}
