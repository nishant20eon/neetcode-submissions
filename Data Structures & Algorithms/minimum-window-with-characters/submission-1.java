class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int requiredCount = t.length();

        int i = 0;
        int j = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        while(j<n) {
            char c = s.charAt(j);

                if (map.getOrDefault(c, 0) > 0) {
                    requiredCount--;
                }
                map.put(c, map.getOrDefault(c, 0) - 1);

                while(requiredCount==0) {
                    int currentWindowSize = j-i+1;

                    if(minWindowSize>currentWindowSize) {
                        minWindowSize=currentWindowSize;
                        start_i=i;
                    }

                    char ci = s.charAt(i);
                    map.put(ci, map.get(ci)+1);

                    if(map.get(ci)>0) {
                        requiredCount++;
                    }
                    i++;
                }
            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, (minWindowSize+start_i));
        
    }
}