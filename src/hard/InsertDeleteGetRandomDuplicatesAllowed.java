package hard;

import java.util.*;

/*
    Design a data structure that supports all following operations in average O(1) time.

    Note: Duplicate elements are allowed.
    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements.

    The probability of each element being returned is linearly related to the number of same value the collection contains.
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

    private int n = new Random().nextInt(100);

    private List<Integer> t = new ArrayList<>();

    private Map<Integer, List<Integer>> f = new HashMap<>();

    public boolean insert(int val) {

        List<Integer> x = f.get(val);
        boolean flag = x == null;
        if (flag) x = new ArrayList<>();
        x.add(t.size());
        f.put(val, x);
        t.add(val);
        return flag;
    }

    public boolean remove(int val) {

        List<Integer> x = f.get(val);
        if (x == null) return false;
        int y = x.get(x.size()-1);
        int z = t.size() - 1;
        t.set(y, t.get(z));
        t.remove(z);
        x.remove(x.size()-1);
        if (x.isEmpty()) f.remove(val);
        else f.put(val, x);
        return true;
    }

    public int getRandom() {
        return t.get(n++ % t.size());
    }

}
