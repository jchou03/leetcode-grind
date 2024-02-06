package grind.Medium;

/*
understand:
- given a sorted array
- rotated between 1 and n times
- need to find minimum element in log(n) time
- all values in nums are unique

match:
- binary search

plan:
- use left and right pointers as range to search in
- get middle value mid = nums[(left + right)/2]
- if mid < nums[right] then right = mid
- if mid > nums[right] then left = mid

find minimum in a rotated array
runtime: 100%, memory: 41%

*/

public class M153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(right == left + 1){
                if(nums[left] < nums[right]){
                    right = left;
                }else{
                    left++;
                }
            }else{
                int mid = (left + right)/2;
                if(nums[mid] < nums[right]){
                    right = mid;
                }else if(nums[mid] > nums[right]){
                    left = mid;
                }
            }
        }

        return nums[right];
    }
}
