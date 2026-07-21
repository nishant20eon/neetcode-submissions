class Solution {

    public String encode(List<String> strs) {
        // form length#stringleng#string
        StringBuilder result = new StringBuilder();

        for(String str : strs) {
            result.append(str.length())
                .append("#")
                .append(str);
        }
        return new String(result);

    }

    public List<String> decode(String str) {

        List<String> decode = new ArrayList<>();

        int i=0;

        while(i<str.length()) {

            int j=i;

            while(str.charAt(j)!='#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            String word = str.substring(j+1, j+1+len);
            decode.add(word);
            i=j+1+len;
        }
        return decode;

    }
}
