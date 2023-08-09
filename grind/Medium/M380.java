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
            if(set.add(val)){
                return ar.add(val);
            }else{
                return false;
            }
        }
        
        public boolean remove(int val) {
            return ar.remove((Integer)val) && set.remove((Integer)val);
        }
        
        public int getRandom() {
            return ar.get((int)(Math.random() * set.size()));
        }
    }
    
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
