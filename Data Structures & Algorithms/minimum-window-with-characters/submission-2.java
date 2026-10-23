class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        int requiredcount = t.length();

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int minimumwindowlength = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int start_pos_win = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            if (freq[c] > 0) {
                requiredcount--;
            }

            freq[c]--;

            while (requiredcount == 0) {

                // Store minimum valid window
                char c_left = s.charAt(left);

                int current_window_len = right - left + 1;

                if (minimumwindowlength > current_window_len) {
                    minimumwindowlength = current_window_len;
                    start_pos_win = left;
                }

                // Shrink window
                freq[c_left]++;

                if (freq[c_left] > 0) {
                    requiredcount++;
                }

                left++;
            }

            right++;
        }

        String result = minimumwindowlength == Integer.MAX_VALUE
                ? ""
                : s.substring(start_pos_win,
                              start_pos_win + minimumwindowlength);

        return result;
    }
}