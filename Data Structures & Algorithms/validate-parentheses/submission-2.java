class Solution {
    public boolean isValid(String s) {
        int j = 0;
        Stack<Character> stack = new Stack();
        while(j<s.length()) {
            char bracket = s.charAt(j);

            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else { 
                if(stack.isEmpty())
                return false;

                char open = stack.pop();
                if(isNotMatching(open,bracket)) return false;
            }
            j++;
    }

        return stack.isEmpty(); 
    }

    private boolean isNotMatching(char open, char close) {
        return (('['==open && ']'!=close) || ('{' == open && '}' != close) || ('(' == open && ')' != close));
    }

}

