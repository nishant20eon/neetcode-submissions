class Solution {
    public boolean isValid(String s) {
        int j = 0;
        Stack<Character> stack = new Stack();
        while(j<s.length()) {
            char bracket = s.charAt(j);

            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if(!stack.isEmpty() && ((bracket == ')' && stack.peek() == '(') || (bracket == '}' && stack.peek() == '{') || (bracket == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                return false;
            }
            j++;
        }

        return stack.isEmpty();

        
    }
}