package grind.Medium;

/*
runtime: O(n) 28%
memory: O(1) 90%
 */

public class M167 {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        while(p1 < p2){
            int num = numbers[p1] + numbers[p2];
            if(num == target){
                break;
            }else if(num < target){
                p1++;
            }else{
                p2--;
            }
        }
        return new int[]{p1 + 1, p2 + 1};
    }
}
