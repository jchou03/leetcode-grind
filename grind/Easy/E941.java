package grind.Easy;

// Valid mountain array

public class E941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }

        boolean inc = true;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == prev) return false;
            else if(inc){
                if(arr[i] < prev){
                    if(i == 1) return false;
                    inc = false;
                }
                prev = arr[i];
            }else{
                if(arr[i] > prev) return false;
                prev = arr[i];
            }
        }

        return !inc;
    }
}
