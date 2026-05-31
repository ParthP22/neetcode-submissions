class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty() && minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
    
        // int popped = stack.pop();
        // if(popped == minStack.peek()){
        //     minStack.pop();
        // }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
