class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        Map<Character, Integer> target = new HashMap<>();

        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        String ans = null;

        for (int i = 0; i < s.length(); i++) {

            Map<Character, Integer> window = new HashMap<>();

            for (int j = i; j < s.length(); j++) {

                char c = s.charAt(j);
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (contains(target, window)) {

                    String str = s.substring(i, j + 1);

                    if (ans == null || str.length() < ans.length()) {
                        ans = str;
                    }

                    break;
                }
            }
        }

        return ans == null ? "" : ans;
    }

    public boolean contains(Map<Character, Integer> target,
                            Map<Character, Integer> window) {

        for (Character ch : target.keySet()) {

            if (!window.containsKey(ch))
                return false;

            if (window.get(ch) < target.get(ch))
                return false;
        }

        return true;
    }
}