/*
Understand
    - given an array of characters representing different kinds of tasks
    - each task takes one unit of computation to complete
    - there must be n units of computation between executions of the same kind of task
    - determine the minimum number of computational cycles it takes to finish all tasks
        - note the minimum length will be at least m + ((m - 1) * n) where m is the number of the most common task
    
    happy case
        tasks = ["A","A","A","B","B","B"], n = 2 -> 8
        tasks = ["A","A","A","B","B","B"], n = 0 -> 6
        tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2 -> 16
        tasks = ["A","B","C","D","A","B","C","D"], n = 2 -> 8
            a > b > c > d > a > b > c > d
            a > b > c > a > d > b > d > c

    edge case
        tasks = ["A"], n = 120 -> 1
        tasks = [], n = 121313 -> 0


Match
    - this could be a hashmap solution to keep track of the number of each task

Plan
    - iterate over task array and log in hashmap how many of each task there are
    - then iterate over map to determine the max number of tasks (and how many of that sized task there are)
    - len = m + (m - 1) * n (where m is the largest number one) with (m - 1) * n extra spots. then fill extra spots and extend size as needed to fit the rest of the tasks

Implement

Review

Evaluate
    runtime: O(n)
    memory: O(n)
    
    leetcode performance
        runtime: 52%
        memory: 72%
 */

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args){
        String[] test_s = new String[]{
            "AAABBB",
            "AAABBB",
            "AAAAAABCDEFG",
            "ABCDABCD",
            "A",
            ""
        };
        int[] test_n = new int[]{
            2,
            0,
            2,
            2,
            120,
            8
        };
        int[] answers = new int[]{8,6,16,8,1,0};
        for(int i = 0; i < test_s.length; i++){
            System.out.printf("Beginning test %d\n", i + 1);
            int res = taskScheduler(test_s[i], test_n[i]);
            System.out.printf("Test %s res: %d answer: %d\n\n", (res == answers[i] ? "Passed" : "Failed"), res, answers[i]);
        }
    }

    public static int taskScheduler(String tasks, int n){
        if(tasks.length() <= 1) return tasks.length();
        // use a hashmap to store the count of each task
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < tasks.length(); i++){
            char c = tasks.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        // convert the hashmap into a sorted list
        ArrayList<Integer> list = new ArrayList<Integer>(map.size());
        for(char c : map.keySet()){
            list.add(map.get(c));
        }
        list.sort(null);
        int avalSpace = ((list.get(list.size() - 1) - 1) * n);
        int maxCount = list.get(list.size() - 1);
        int curLength = maxCount + avalSpace;
        for(int i = list.size() - 2; i >= 0; i--){
            if(list.get(i) == maxCount){
                avalSpace++;
                curLength++;
            }
            avalSpace -= list.get(i);
        }
        if(avalSpace < 0) curLength -= avalSpace;
        
        return curLength;

    }
}
