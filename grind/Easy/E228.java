package grind.Easy;

import java.util.ArrayList;
import java.util.List;

/*
 * shorten numbers into ranges
 */

public class E228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        int rangeStart = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1] + 1){
                System.out.println(nums[i]);
                if(rangeStart != nums[i - 1]){
                    res.add("" + rangeStart + "->" + nums[i - 1]);
                }else{
                    res.add("" + rangeStart);
                }
                rangeStart = nums[i];
            }
        }

        if(rangeStart != nums[nums.length - 1]){
            res.add("" + rangeStart + "->" + nums[ nums.length - 1 ]);
        }else{
            res.add("" + rangeStart);
        }
        return res;
    }
}
