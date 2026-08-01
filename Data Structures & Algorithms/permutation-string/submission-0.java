class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int [] freqs1 = new int[26];
        int [] freqs2 = new int[26];

        for(char c:s1.toCharArray()) {
            freqs1[c-'a']++;
        }

        int i=0;
        int j=0;

        int k = s1.length();

        while(j<s2.length()) {
            freqs2[s2.charAt(j)-'a']++;

            while((j-i+1)>k) {
                freqs2[s2.charAt(i)-'a']--;
                i++;
            }

            if ((j-i+1)==k && Arrays.equals(freqs1, freqs2)) {
                    return true;
                }

            j++;
        }
        return false;
        
    }
}