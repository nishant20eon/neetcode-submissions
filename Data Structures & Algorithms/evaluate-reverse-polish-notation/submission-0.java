class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = calculateExpression(token,a,b);
                stack.push(result);
            } else {
              Integer value = Integer.parseInt(token);
                stack.push(value);
            }
        }
        return stack.pop();   
    }
    private int calculateExpression(String token, int a, int b) {
        switch (token) {
            case "+":
                return a + b;

            case "*":
                return a * b;

            case "-":
                return b - a;

            case "/":
                return b / a;

            default:
                return 0;
        }
    }
}