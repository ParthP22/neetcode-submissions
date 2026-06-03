class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] car = new int[position.length][2];

        for(int i = 0; i < speed.length; i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        Arrays.sort(car, (a,b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        stack.push((double)(target - car[0][0])/car[0][1]);

        for(int i = 1; i < car.length; i++){
            double time = (double)(target - car[i][0])/car[i][1];
            if(time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
