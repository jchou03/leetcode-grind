/*
Understand
    given an array of size m x n of ints
    heights[i][j] = the height of the person standing at index i,j
    a person can see another person who is on the right or to the bottom of them and if all of the 
        people in between them are lower than the 2 heights
            - in order to determine if a person can see another person, we need to know the max value of neighbors

    oberservation:
        - all people that aren't the bottom right person will be able to see at least 1 person (person to their right, or person below them)

Match
    - what data structures would be able to use memory to reduce the runtime?

Plan
    - currently plan to implement the trivial solution by iterating over the row and column for each index
        - at each coord i,j : keep track of the max as you go to the right/down, and if the current index is greater than the max, update max as well as number of people that person can see

 */
public class GridSee {
    public int[][] gridSee(int[][] heights){
        int[][] res = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                int tempMax = 0;
                for(int k = i; k < heights.length; k++){
                    if(heights[k][j] > tempMax){
                        tempMax = heights[k][j];
                        res[i][j] += 1;
                    }
                }
                tempMax = 0;
                for(int l = j; l < heights[0].length; l++){
                    if(heights[i][l] > tempMax){
                        tempMax = heights[i][l];
                        res[i][j] += 1;
                    }
                }
            }
        }
        return res;
    }
}
