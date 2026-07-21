class Solution {
    public String encode(List<String> strs) {
        String encodedResult = new String();

        for (String str : strs) {
            encodedResult += str;
            encodedResult += "`";
        }

        return encodedResult;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String str1 = new String();
        for (int index = 0; index < str.length(); index++) {
            char c = str.charAt(index);
            if (c != '`') {
                String s = c + "";
                str1 += s;
            } else {
                result.add(str1);
                str1 = new String();
            }
        }
        return result;
    }
}
