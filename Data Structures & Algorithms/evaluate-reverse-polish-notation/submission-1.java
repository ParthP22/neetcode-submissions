class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int tmp1 = 0;
        int tmp2 = 0;
        for(int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "+":
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp1 + tmp2);
                    continue;
                case "/":
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp2 / tmp1);
                    continue;
                case "-":
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp2 - tmp1);
                    continue;
                case "*":
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp1 * tmp2);
                    continue;
            }
            stack.push(Integer.parseInt(tokens[i]));
            
        }
        return stack.pop();
    }
}
