package grind.need_improvement;

// check if it is possible to make the trip along circle road going from gas station to gas station
// implemented trivial solution

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // trivial solution (go around the entire ring and check each gas station)
        int gTank = 0;
        for(int i = 0; i < gas.length; i++){
            gTank += (gas[i] - cost[i]);
        }

        if(gTank < 0){
            System.out.println("no solution");
            return -1;
        }else{
            // check for which index 
            for(int i = 0; i < gas.length; i++){
                gTank = 0;
                for(int j = 0; j < gas.length; j++){
                    gTank += (gas[(i + j) % gas.length] - cost[(i + j) % gas.length]);
                    if(gTank < 0) break;
                }
                if(gTank >= 0) return i;
            }
        }
        return -1;
    }
}