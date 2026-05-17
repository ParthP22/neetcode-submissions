class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int popped = stack.pop();
        if(popped == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
