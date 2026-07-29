class Solution {
    public int characterReplacement(String s, int k) {

        int left=0;
        int maxfreq=0;
        int ans=0;
        int[] freq = new int[26];
        for(int right =0;right<s.length();right++) {
                freq[s.charAt(right)-'A']++;
                for(int i=0;i<26;i++) {
                    maxfreq = Math.max(maxfreq,freq[i]);
                }

                while((right-left+1-maxfreq)>k) {
                    freq[s.charAt(left)-'A']--;
                    left++;
                }
                ans=Math.max(ans,right-left+1);
            }
        return ans;
    }
}