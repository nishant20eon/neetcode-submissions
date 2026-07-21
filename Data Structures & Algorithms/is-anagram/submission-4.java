class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freqArray = new int[26];

        for(char c: s.toCharArray()) {
            int index = c -'a';
            freqArray[index]+=1;
        }

        for(char c: t.toCharArray()) {
            int index = c -'a';
            freqArray[index]-=1;
        }

        for(int val:freqArray) {
            if(val!=0) return false;
        }
        return true;

    }
}
