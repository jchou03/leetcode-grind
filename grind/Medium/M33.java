package grind.Medium;

/*
understand
- given array nums
    - sorted in ascending order
    - distinct values (no duplicates)
- possibly rotated
- must find index of target if it is in nums
- log(n) time

match: 
- binary search (with modifications)

plan:
- use a left and right pointer to narrow search window
- calculate middle 
- if left < target < mid or target < mid < left or mid < left < target then left case, else right

runtime: 100%, memory: 19%

*/

class M33{
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // System.out.printf("left: %d, right: %d\n", left, right);
            if(target == nums[left]){
                return left;
            }else if(target == nums[right]){
                return right;
            }else if(right <= left + 1){
                return -1;
            }else{
                int mid = (left + right)/2;
                if(nums[mid] == target) return mid;
    
                if((nums[mid] > target && target > nums[left]) || (nums[left] > nums[mid] && nums[mid] > target) || (target > nums[left] && nums[left] > nums[mid])){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return right;
    }
}
