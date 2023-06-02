package grind.Easy;

// 2 pointer palendrome solution 
// runtime: 70%, memory: 83%

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