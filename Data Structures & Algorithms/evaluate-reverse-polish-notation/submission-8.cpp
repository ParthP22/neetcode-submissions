class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> stk;

        for(int i = 0; i < tokens.size(); i++){
            string curr = tokens[i];
            if(curr == "+"){
                int num1 = stk.top();
                stk.pop();
                int num2 = stk.top();
                stk.pop();
                stk.push(num2 + num1);
            }
            else if(curr == "-"){
                int num1 = stk.top();
                stk.pop();
                int num2 = stk.top();
                stk.pop();
                stk.push(num2 - num1);
            }
            else if(curr == "*"){
                int num1 = stk.top();
                stk.pop();
                int num2 = stk.top();
                stk.pop();
                stk.push(num2 * num1);
            }
            else if(curr == "/"){
                int num1 = stk.top();
                stk.pop();
                int num2 = stk.top();
                stk.pop();
                stk.push(num2 / num1);
            }
            else{
                stk.push(stoi(curr));
            }
        }

        return stk.top();
    }
};
