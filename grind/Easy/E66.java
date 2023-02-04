package grind.Easy;

// plus one to integer stored by digit in array
// runtime beats 100%, memory beats 57%

public class E66 {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        // if reached here, that means that we need to add a new digit to the front
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for(int i = 0; i < digits.length; i++){
            newDigits[i + 1] = digits[i];
        }
        return newDigits;
    }
}
