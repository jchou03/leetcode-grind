// package CodePath Advanced TIP.Week 1;

public class Substring {
    public static void main(String[] args) {

        String[] s1 = new String[]{"testing", "labratory", "cat", "aaaaaaaaaaaaaa", "boogacatcatcatooga"};
        String[] s2 = new String[]{"test", "rat", "meow", "aaaaaaaaaaaaaa", "catcat"};
        boolean[] a = new boolean[]{true, true, false, true, true};

        for(int i = 0; i < s1.length; i++){
            if(subString(s1[i], s2[i]) != a[i]){
                System.out.println("Test failed on case: s1-" + s1[i] + " s2-" + s2[i] + " a-" + a[i]);
            }
            System.out.printf("Test %d compelted\n", i);
        }
        System.out.println("Tests completed");


    }

    private static boolean subString(String s1, String s2){

        // impelement trivial solution (O(n^2) solution)
        for(int i = 0; i <= s1.length() - s2.length(); i++){
            if(s1.charAt(i) == s2.charAt(0)){
                boolean res = true;
                for(int j = 0; j < s2.length(); j++){
                    if(s1.charAt(i + j) != s2.charAt(j)) res = false;
                }
                return res;
            }
        }
        return false;
    }
}
