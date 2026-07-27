class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int longLen = 0;

        int i=0;
        int j=0;

        while(j<s.length()) {

            char c = s.charAt(j);
                while(set.contains(c)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            set.add(c);
            longLen = Math.max(longLen, (j-i+1));
            j++;
        }

            return longLen;   // Final update
        }
        
    }
