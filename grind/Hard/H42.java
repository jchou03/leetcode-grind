package grind.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class H42 {
    public static void main(String[] args){
        int[][] tests = new int[][]{
            new int[]{0,1,0,2,1,0,1,3,2,1,2,1},
            new int[]{4,2,0,3,2,5}
        };
        int[] answers = new int[]{6, 9};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Beginning test %d\n", i + 1);
            int res = trap(tests[i]);
            System.out.printf("Test %s res: %d answer: %d\n\n", (res == answers[i] ? "Passed!" : "Failed :("), res, answers[i]);
        }
    }


    public static int trap(int[] height) {
        // construct an array that stores the positions of blocks on each row
        int max = height[0];
        int secondMax = 0;
        for(int i = 1; i < height.length; i++){
            if(height[i] > max){
                secondMax = max;
                max = height[i];
            }else if(height[i] != max && height[i] > secondMax){
                secondMax = height[i];
            }
        }
        System.out.println(secondMax);

        ArrayList<ArrayList<Integer>> blocks = new ArrayList<ArrayList<Integer>>(secondMax);
        System.out.println(blocks.size());
        for(int i = 0; i < height.length; i++){
            for(int j = 0; j < height[i]; j++){
                if(j < blocks.size()){
                    blocks.get(j).add(i);
                    System.out.println("adding to existing list: " + blocks.get(j));
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    blocks.add(j, list);
                    System.out.println("creating a new list:" + list);
                }
            }
        }

        System.out.println(blocks);

        int trappedRainWater = 0;
        for(ArrayList<Integer> list: blocks){
            if(!list.isEmpty()){
                int prev = list.get(0);
                for(int i = 1; i < list.size(); i++){
                    if(list.get(i) - 1 > prev){
                        trappedRainWater += (list.get(i) - prev) - 1;
                    }
                    prev = list.get(i);
                }
            }
        }
        
        return trappedRainWater;
    }
}
