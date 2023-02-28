package grind.Easy;

// work in progress

public class E67 {
    class Solution {
        public String addBinary(String a, String b) {
    
            String result = "";
            int carry = 0;
            for(int i = 0; i < Math.max(a.length(), b.length()); i++){
                int res = Character.digit(a.charAt(a.length() - 1 - i), 10) + Character.digit(b.charAt(b.length() - 1 - i), 10) + carry;
    
                result = (res % 2) + result;
                carry = res/2;
            }
            if(a.length() < b.length()){
                for(int i = b.length() - 1; i >= 0; i--){
                    int res = Character.digit(b.charAt(b.length() - 1 - i), 10) + carry;
                    result = (res % 2) + result;
                    carry = res/2;
                }
            }
            if(b.length() < a.length()){
                for(int i = a.length() - 1; i >= 0; i--){
                    int res = Character.digit(a.charAt(a.length() - 1 - i), 10) + carry;
                    result = (res % 2) + result;
                    carry = res/2;
                }
            }
            return result;
        }
    }
}
