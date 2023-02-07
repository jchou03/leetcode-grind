package grind.Medium;

// fruits into baskets
// runtime: 99.6%, memory 62%

public class M904 {
    public int totalFruit(int[] fruits) {
        // iterate over array of fruits
        // store the current streak of fruit picked
        // store the two most recent kinds of fruit picked
        int maxFruit = 1;
        // streak to keep track of how many fruit picked in current cycle
        int curStreak = 1;
        // store the second to most recent kind of fruit
        int fruit1 = -1;
        int fruit1_index = 0;
        // store the most recent kind of fruit
        int fruit2 = fruits[0];
        int fruit2_index = 0;
        for(int i = 1; i < fruits.length; i++){
            int current = fruits[i];
            if(current != fruit2 && current != fruit1){
                fruit1 = fruit2;
                fruit1_index = fruit2_index;
                fruit2 = current;
                fruit2_index = i;
                curStreak = i - fruit1_index + 1;
            }else{
                curStreak++;
                if(current == fruit1){
                    fruit1 = fruit2;
                    fruit1_index = fruit2_index;
                    fruit2 = current;
                    fruit2_index = i;
                }
            }
            if(curStreak > maxFruit) maxFruit = curStreak;
            // System.out.println("f1: " + fruit1 + " f2: " + fruit2 + " curstreak: " + curStreak + " i: " + i);
        }
        return maxFruit;
    }
}
