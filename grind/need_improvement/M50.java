package grind.need_improvement;

// implement a power function
// runtime: 100%, memory: 29.9% 
// can improve memory usage

class Solution {
    public double myPow(double x, int n) {
        if(x == 1.0) return x;
        if(n == 0){
            return 1;
        }else if(n > 0){
            if (n == 1){
                return x;
            }else if(n % 2 == 0){
                return myPow(x * x, n/2);
            } else{
                return myPow(x * x, n/2) * x;
            }
        }else{
            if(n == -1){
                return 1/x;
            }else if(n % 2 == 0){
                return myPow(x * x, n/2);
            }else{
                return myPow(x * x, n/2) * (1/x);
            }
        }
    }
}