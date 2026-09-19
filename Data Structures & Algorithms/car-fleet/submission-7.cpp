class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,int>> cars;
        int n = speed.size();

        for(int i = 0; i < n; i++){
            cars.push_back({position[i], speed[i]});
        }

        // We sort in descending order by POSITION of
        // the car, NOT the speed.
        sort(cars.rbegin(), cars.rend());

        int fleets = 1;

        double prev_time = (double)(target - cars[0].first) / cars[0].second;

        for(int i = 1; i < n; i++){
            double curr_time = (double)(target - cars[i].first) / cars[i].second;

            // The cars vector was sorted in descending order by
            // the position parameter. 
            // So, prev_time refers to a car that started closer to
            // to the finish line and curr_time refers to a car
            // that started farther behind that one. 
            // So, if curr_time > prev_time, that means this car
            // won't ever come close to catching up, let alone
            // passing the car in front. So, a new fleet is formed
            // However, if curr_time == prev_time, then that means
            // this car caught up. So, it will be in the same fleet.
            // If curr_time < prev_time, that means this car cannot
            // pass the other one, because the rules of this problem
            // say that cars cannot pass one another. So, again, this
            // car will join the fleet formed by the car that originally
            // started ahead of it.
            if(curr_time > prev_time){
                fleets++;
                prev_time = curr_time;
            }
        }

        return fleets;
    }
};
