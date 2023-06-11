// https://guides.codepath.org/compsci/Next-Prime

public class NextPrime {
    public static void main(String[] args){
        int[] tests = new int[]{1, 10, 3, 49, 0, -10};
        int[] answers = new int[]{2, 11, 5, 53, 2, 2};
        for(int i = 0; i < tests.length; i++){
            System.out.printf("Test %d: result: %d answer: %d\n", i, nextPrime(tests[i]), answers[i]);
        }
    }

    private static int nextPrime(int p){
        // trivial solution and iterate over every digit
        if(p <= 0) return 2;
        int nextP = p + 1;
        while(!isPrime(nextP)){
            // System.out.printf("currently testing nextp: %d\n", nextP);
            nextP++;
        }
        return nextP;
    }

    private static boolean isPrime(int p){
        // check every integer before p
        for(int i = 2; i <= Math.sqrt(p); i++){
            if(p % i == 0) return false;
        }
        return true;
    }
}
