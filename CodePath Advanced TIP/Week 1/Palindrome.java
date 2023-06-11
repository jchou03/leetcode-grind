// https://guides.codepath.org/compsci/Valid-Palindrome

public class Palindrome {
    public static void main(String[] args){
        String[] strings = new String[]{"racecar", "A man, a plan, a canal: Panama", " ", "oogabooga"};
        boolean[] answers = new boolean[]{true, true, true, false};

        for(int i = 0; i < strings.length; i++){
            if(palindrome(strings[i]) != answers[i]){
                System.out.println("Failed on: " + strings[i]);
            }
            System.out.printf("Finished test case %d \n", i);
        }
        System.out.println("Done with all test cases");
    }   

    private static boolean palindrome(String s){
        // two pointer solution
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();

        while(i < j){
            while(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
