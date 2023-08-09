package grind.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class M380 {
    class RandomizedSet {
        private Set<Integer> set;
        private ArrayList<Integer> ar;
        public RandomizedSet() {
            set = new HashSet<Integer>();
            ar = new ArrayList<Integer>();
        }
        
        public boolean insert(int val) {
            ar.add(val);
            return set.add(val);
        }
        
        public boolean remove(int val) {
            ar.remove((Integer)val);
            return set.remove(val);
        }
        
        public int getRandom() {
            return ar.get((int)(Math.random() * set.size()));
        }
    }
}
