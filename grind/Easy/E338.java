package grind.Easy;

// counting bits
// runtime: 99%, memory: 5%
// update, it is O(1) space, and it seems that the memory efficiency of this problem is really tight, 
// so it's probablly ok in terms of space efficiency

public class E338 {
    public int[] countBits(int n) {
        int[] oneBits = new int[n+1];
        oneBits[0] = 0;
        for(int i = 1; i <= n; i++){
            if(i % 2 == 1){
                oneBits[i] = oneBits[i/2] + 1;
            }else{
                oneBits[i] = oneBits[i/2];
            }
        }
        return oneBits;
    }
}
