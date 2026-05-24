class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int sum = num1 + num2;
                stack.push(sum);
            }
            else if(tokens[i].equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int diff = num2 - num1;
                stack.push(diff);
            }
            else if(tokens[i].equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int prod = num1 * num2;
                stack.push(prod);
            }
            else if(tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int quot = num2 / num1;
                stack.push(quot);
            }  
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
