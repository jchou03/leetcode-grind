package grind.Medium;

public class M12 {
    public String intToRoman(int num) {
        /*
        parse the number by digits (guaranteed to have max 4 digits)
        calculate how to represent each digit using the appropriate letters
        */
        String s = "" + num;
        String res = "";
        for(int i = s.length() - 1; i >= 0; i--){
            int digit = Integer.parseInt("" + s.charAt(i));
            if(i == s.length() - 1){
                res = digitToRoman(digit, 'I', 'V', 'X');
            }else if(i == s.length() - 2){
                res = digitToRoman(digit, 'X', 'L', 'C') + res;
            }else if(i == s.length() - 3){
                res = digitToRoman(digit, 'C', 'D', 'M') + res;
            }else{
                res = digitToRoman(digit, 'M', 'Q', 'Q') + res;
            }
        }
        return res;
    }
    private String digitToRoman(int num, char one, char five, char ten){
        String res = "";
        if(num == 9){
            res = res + one + ten;
            num = 0;
        }else if(num >= 5){
            res += five;
            num -= 5;
        }else if(num == 4){
            res = res + one + five;
            num = 0;
        }

        for(int i = 0; i < num; i++){
            res += one;
            // System.out.println("adding one");
        }
        return res;
    }
}
