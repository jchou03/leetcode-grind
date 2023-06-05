package grind.Medium;

// calculate the h-index of a professor given an array with the number of citations for each report
// runtime: 61%, memory: 46%

class Solution {
    public int hIndex(int[] citations) {
        // sort array then iterate over the array to determine the h-index
        Arrays.sort(citations);
        // count backwards over sorted array to determine largest h index
        int h_count = 0;
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations[i] > h_count) h_count++;
        }
        return h_count;
    }
}