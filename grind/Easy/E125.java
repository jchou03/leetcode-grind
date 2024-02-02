package grind.Easy;

// 2 pointer palendrome solution 
// runtime: 70%, memory: 83% (resolved)

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int p1 = 0;
        int p2 = s.length() -1;
        while(p1 < p2){
            while(p1 < s.length() && !(Character.isAlphabetic(s.charAt(p1)) || Character.isDigit(s.charAt(p1)))){
                p1++;
            }
            while( p2 >= 0 && !(Character.isAlphabetic(s.charAt(p2)) || Character.isDigit(s.charAt(p2)))){
                p2--;
            }
            // System.out.println("p1: " + s.charAt(p1) + " p2: " + s.charAt(p2));
            if(p1 >= s.length() || p2 < 0){
                return true;
            }else if(s.charAt(p1) != s.charAt(p2)){
                return false;
            }else{
                p1++;
                p2--;
            }
        }
        return true;
    }
}

// attempted solution for O(1) space
/*
 * class Solution {
    public void rotate(int[] nums, int k) {
        // use algo to jump around the array starting at 0, then at 0-k, then 0-2k, etc
        // store the number we just replaced for moving it to the next step
        // use an index counter to stop when the array is all done
        int count = 0;
        int i = 0;
        int prev = nums[i];
        int temp = prev;
        k = k % nums.length;
        if(nums.length == 1 || k == 0) return;
        if(nums.length % k == 0){
            // complete each of the smaller loops
            for(int j = 0; j < nums.length / (nums.length / k); j++){
                i = j;
                prev = nums[j];
                do{
                    i = (i + k < nums.length) ? (i + k) : (i + k) % nums.length;
                    temp = nums[i];
                    nums[i] = prev;
                    prev = temp;
                    System.out.println("i is: " + i + " prev: " + prev + " temp: " + temp + Arrays.toString(nums));
                } while(i != j);
            }
        }else{
            while(count < nums.length){
                i = (i + k < nums.length) ? (i + k) : (i + k) % nums.length;
                temp = nums[i];
                nums[i] = prev;
                prev = temp;
                count++;
                if(i == 0 && count < nums.length){
                    i++;
                    count--;
                    prev = nums[i];
                }             
                System.out.println("i is: " + i + " prev: " + prev + " temp: " + temp + Arrays.toString(nums));
            }
        }

    }
}
 * 
 */