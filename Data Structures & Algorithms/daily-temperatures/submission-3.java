class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int index = stack.pop();
                    result[index] = i - index;
                    
                }
                stack.push(i);
            }
        }

        return result;
    }
}
