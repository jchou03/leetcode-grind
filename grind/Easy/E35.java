package grind.Easy;

// search insert position
// runtime: 100%, memory: 73%

public class E35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;
        if(nums[0] > target) return 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }
        }
        return low;
    }
}
