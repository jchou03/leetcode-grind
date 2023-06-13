import java.util.*;

public class PossiblePhoneStrings {

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        System.out.println(Arrays.toString(phoneStrings("23", 0, "", new ArrayList<String>(), map)));
    }

    public static Object[] phoneStrings(String number, int index, String curRes, ArrayList<String> res, HashMap<Integer, String> map){
        
        if(curRes.length() == number.length()){
            res.add(curRes);
        }else{
            for(int i = 0; i < map.get(Character.digit(number.charAt(index), 10)).length(); i++){
                phoneStrings(number, index + 1, curRes + map.get(Character.digit(number.charAt(index), 10)).charAt(i), res, map);
            }
        }

        return res.toArray();
    }
    

}
