class MinStack {
// I actually implemented this solution myself this time.
// Yes, I've seen the solution before, but that was a while
// back, and I can't even remember if it was the two-stack 
// or single-stack version. 
// I tried to apply the intuition of the single-stack version
// that I remembered.
// Basically, every time you push, you push twice: the 1st
// is the actual value and the 2nd is the minimum value UP UNTIL
// THAT POINT. Whenever you push, you also check to see if the
// new value could potentially be the new minimum value. If so,
// you push as the 2nd value, not the previous min value. It
// is important to push twice, because we are not keeping memory
// of the order of the minimums. For example, 1 might be the first
// minimum, then 0, then 0 again, but then we might pop that 0, so
// then how do we know what the previous minimum was? We could
// mistakenly pick 1 as our min if we assume that there are no
// duplicates, but that would be wrong. So, we always push in pairs:
// the actual value 1st, then the new minimum value 2nd. Now, when
// we pop, we simply pop twice and our old minimum will now be at the
// top of the stack.
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
