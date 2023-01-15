package grind.Easy;

// Binary Search

public class E704 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int mid = nums[(j + i)/2];
            if(mid > target){
                j = (j + i)/2 - 1;
            }else if(mid < target){
                i = (j + i)/2 + 1;
            }else{
                return (i + j)/2;
            }
        }
        return -1;
    }
}
