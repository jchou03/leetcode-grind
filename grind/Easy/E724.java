package grind.Easy;

// Find Pivot Index
class E724 {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 1; i < nums.length; i++){
            rightSum += nums[i];
        }
        if(leftSum == rightSum){
            return 0;
        } 
        else {
            for(int i = 1; i < nums.length-1; i++){
                leftSum += nums[i-1];
                rightSum -= nums[i];
                if(leftSum == rightSum) return i;
            }
            if(nums.length >= 2){
                leftSum += nums[nums.length - 2];
                rightSum -= nums[nums.length - 1];
                if(leftSum == rightSum){
                    return nums.length - 1;
                }
            }
            return -1;
        }
    }
}