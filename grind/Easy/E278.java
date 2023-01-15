package grind.Easy;

// first bad

public class E278 extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1;
        int j = n;
        // int counter = 0;
        while(i < j){
            int mid = i + (j - i)/2;
            // System.out.println("i: " + i + " j: " + j + " counter: " + (++counter));
            if(isBadVersion(mid)){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        // System.out.println("calls: " + counter);
        return j;
    }
}
