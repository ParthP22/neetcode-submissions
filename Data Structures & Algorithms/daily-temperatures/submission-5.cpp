class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<int> stk;

        vector<int> ret(temperatures.size(),0);

        for(int i = 0; i < temperatures.size(); i++){
            while(!stk.empty() && temperatures[stk.top()] < temperatures[i]){
                int top = stk.top();
                stk.pop();

                ret[top] = i - top;
            }

            stk.push(i);
        }

        return ret;
    }
};
