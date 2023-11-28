package grind.Medium;

public class M6 {
    class Solution {
        public String convert(String s, int numRows) {
            /*
            use an array of strings to store the string of each row then return all of them concated together
            */
    
            String[] rows = new String[numRows];
            for(int i = 0; i < numRows; i++){
                rows[i] = "";
            }
            // now iterate over the entire string and add each character to the appropriate row
            for(int i = 0; i < s.length(); i++){
                int rowIndex = i % (2 * numRows - 1);
                if(rowIndex >= numRows){
                    rowIndex = (2*numRows - 1) - rowIndex;
                }
    
                rows[rowIndex] += s.charAt(i);
            }
    
            String res = "";
    
            for(int i = 0; i < rows.length; i++){
                res += rows[i];
                System.out.println(rows[i]);
            }
    
            return res;
        }
    }
}
