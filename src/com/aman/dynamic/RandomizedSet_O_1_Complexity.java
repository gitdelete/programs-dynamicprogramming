package com.aman.dynamic;

import java.util.*;

public class RandomizedSet_O_1_Complexity {
    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    Random r = null;
    public RandomizedSet_O_1_Complexity() {
         list = new ArrayList<>();
         map = new HashMap<>();
         r= new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.get(val) == null)
            return false;
        int index = map.get(val);
        if (index < list.size() - 1 ) { // not the last one than overwrite the last one with this val
            int lastone = list.get(list.size() - 1 );
            list.set( index , lastone );
            map.put(lastone, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        
        return list.get(r.nextInt(list.size()));
      
    }

    public static void main(String[] args) {
        RandomizedSet_O_1_Complexity obj = new RandomizedSet_O_1_Complexity();
        boolean param_1 = obj.insert(2);
        boolean param_2 = obj.insert(3);
        boolean param_3 = obj.remove(3);
        int param_4 = obj.getRandom();
        System.out.println(param_4);
    }
}

