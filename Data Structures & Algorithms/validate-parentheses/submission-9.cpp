class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;

        for(int i = 0; i < s.length(); i++){
            char curr = s[i];

            if(curr == ')'){
                if(stk.empty() || stk.top() != '('){
                    return false;
                }
                else{
                    stk.pop();
                }
            }
            else if(curr == '}'){
                if(stk.empty() || stk.top() != '{'){
                    return false;
                }
                else{
                    stk.pop();
                }
            }
            else if(curr == ']'){
                if(stk.empty() || stk.top() != '['){
                    return false;
                }
                else{
                    stk.pop();
                }
            }
            else{
                stk.push(curr);
            }
        }

        return stk.empty();
    }
};
