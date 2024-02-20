package grind.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
understand
- given distinct integers (candidates)
- must return list of all unique combinations of candidates where chosen numbers sum to target
- the same number can be chosen from candidates an unlimited number of times (can contain duplicates)

plan
- recursive?
    - for each of the elements in cadidates
        - subtract element from target and solve for the number of ways to reach the smaller target
        - how to handle duplicates? 
            - can only calculate solution with smaller range of candidates (only values greater than x for example)

runtime: 86%, memory: 56%
            */

public class M39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, 0);
    }

    private List<List<Integer>> helper(int[] candidates, int target, int gtIndex){
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(gtIndex >= candidates.length || candidates[gtIndex] > target) return res;

        for(int i = gtIndex; i < candidates.length; i++){
            if(candidates[i] == target){
                List<Integer> ls = new ArrayList<Integer>();
                ls.add(candidates[i]);
                res.add(ls);
            }else{
                // System.out.println(candidates[i]);
                List<List<Integer>> temp = helper(candidates, target - candidates[i], i);
                // System.out.println(temp);
                for(List<Integer> ls : temp){
                    ls.add(candidates[i]);
                    // System.out.println(ls);
                }
                // System.out.println(temp + "\n");
                res.addAll(temp);
            }
        }
        return res;
    }
}
