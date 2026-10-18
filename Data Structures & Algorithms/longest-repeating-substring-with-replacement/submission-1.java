class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq= new int[26];

        int mf = 0;

        int left =0;
        int right = 0;
        int window_len;
        int replace_char_len;
        int output=0;

        while(right<s.length()) {
            char cr = s.charAt(right);
            freq[cr-'A']++;
            window_len = (right -left+1);

            for(int i=0;i<26;i++) {
                mf = Math.max(mf, freq[i]);
            }

            replace_char_len = window_len - mf;

            while((window_len - mf)>k) {
                char cl = s.charAt(left);
                freq[cl-'A']--;
                left++;
                window_len = (right -left+1);
                for(int i=0;i<26;i++) {
                mf = Math.max(mf, freq[i]);
                }
                replace_char_len = window_len - mf;
            }
            output=Math.max(output, window_len);
            right++;
        } 
        return output; 
    }
}