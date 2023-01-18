package grind.Easy;

public class E733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // get the original color of the starting pixel
        int orgColor = image[sr][sc];
        // get the positions of the 4-directional pixels
        if(image[sr][sc] != color){
            image[sr][sc] = color;
            // check the positions to see if they are the same color as the original color (if so, then call floodFill on the new pixel)
            
            if(sr-1 >= 0 && sr-1 < image.length && image[sr-1][sc] == orgColor){
                floodFill(image, sr-1, sc, color);
            }
            if(sc-1 >= 0 && sc-1 < image[0].length && image[sr][sc-1] == orgColor){
                floodFill(image, sr, sc-1, color);
            }
            if(sc+1 >= 0 && sc+1 < image[0].length && image[sr][sc+1] == orgColor){
                floodFill(image, sr, sc+1, color);
            }
            if(sr+1 >= 0 && sr+1 < image.length && image[sr+1][sc] == orgColor){
                floodFill(image, sr+1, sc, color);
            }
        }
        return image;
    }
}
