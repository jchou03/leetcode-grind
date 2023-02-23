package grind.Easy;

// counting bits
// runtime: 59%, memory: 5%

public class E338 {
    public int[] countBits(int n) {
        int[] oneBits = new int[n+1];
        oneBits[0] = 0;
        if(n >= 1) oneBits[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 1){
                oneBits[i] = oneBits[i/2] + 1;
            }else{
                oneBits[i] = oneBits[i/2];
            }
        }
        return oneBits;
    }
}
