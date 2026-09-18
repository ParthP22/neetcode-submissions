class MinStack {
public:
    stack<int> min_stack;

    MinStack() {
        
    }
    
    void push(int val) {
        if(min_stack.empty()){
            min_stack.push(val);
            min_stack.push(val);
        }
        else{
            int min = min_stack.top();

            min_stack.push(val);

            if(val < min){
                min = val;
            }
            min_stack.push(min);
        }
    }
    
    void pop() {
        int min = min_stack.top();
        min_stack.pop();
        min_stack.pop();
    }
    
    int top() {
        int min = min_stack.top();
        min_stack.pop();

        int top = min_stack.top();

        min_stack.push(min);

        return top;
    }
    
    int getMin() {
        return min_stack.top();
    }
};
