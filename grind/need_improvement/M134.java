package grind.need_improvement;

// check if it is possible to make the trip along circle road going from gas station to gas station
// O(n) single pass solution
// runtime: 35%, memory: 76%

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // trivial solution (go around the entire ring and check each gas station)
        int gTank = 0;
        int posGas = 0;
        int posIndex = 0;
        for(int i = 0; i < gas.length; i++){
            gTank += (gas[i] - cost[i]);
            posGas += (gas[i] - cost[i]);
            if(posGas < 0){
                posGas = 0;
                posIndex = i + 1;
            }
        }

        if(gTank < 0){
            System.out.println("no solution");
            return -1;
        }else{
            return posIndex;
        }
    }
}