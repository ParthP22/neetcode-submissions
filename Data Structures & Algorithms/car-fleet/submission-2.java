class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[speed.length][2];

        for(int i = 0; i < speed.length; i++){
            pairs[i][0] = speed[i];
            pairs[i][1] = position[i];
        }

        Arrays.sort(pairs, (a,b) -> b[1] - a[1]);

        Stack<Double> stack = new Stack<>();
        stack.push((double)(target - pairs[0][1])/pairs[0][0]);

        for(int i = 1; i < speed.length; i++){
            double time = (double)(target - pairs[i][1])/pairs[i][0];
            if(time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
