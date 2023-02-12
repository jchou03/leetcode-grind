package grind.Easy;

// sqrt
// runtime 17%, memory: 23.42%

public class E69 {
    public int mySqrt(int x) {
        int n = 1;
        while(n * n <= x && n < 46341){
            n += 1;
        }
        return n - 1;
    }
}
